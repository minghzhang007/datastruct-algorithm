package com.lewis.datastruct_algorithm.sort.heap;

import com.lewis.datastruct_algorithm.util.RandomUtil;

import java.util.Arrays;

/**
 * 最大索引堆 下标从0开始
 * parent 索引 = (i-1)/2
 * leftChild索引 = 2*i +1
 * rightChild索引 = 2*i +2
 * @author zmh46712
 * @version Id: MaxIndexHeap, v 0.1 2017/5/31 10:02 zmh46712 Exp $
 */
public class MaxIndexHeap<T extends Comparable> {

    /**
     * 最大索引堆中的数据
     */
    protected T[] data;

    /**
     * 最大索引堆中的索引：indexes[x] = i 表示索引i在x的位置
     */
    private int[] indexes;

    /**
     * 最大索引堆中的反向索引：reverseIndexes[i] = x 表示索引i在x的位置
     */
    private int[] reverseIndexes;

    protected int count;

    protected int capacity;

    public MaxIndexHeap(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.count = 0;
        this.capacity = capacity;
        this.indexes = new int[capacity];
        this.reverseIndexes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            reverseIndexes[i] = 0;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int i, T item) {
        assert (count + 1 <= capacity);
        assert (i >= 0 && i <= capacity);
        data[i] = item;
        indexes[count] = i;
        reverseIndexes[i] = count;
        shiftUp(count);
        count++;
    }

    /**
     * 获取最大值
     */
    public T extractMax() {
        assert (count > 0);
        T ret = data[indexes[0]];
        swap(indexes, 0, count - 1);
        reverseIndexes[indexes[count - 1]] = 0;
        count--;
        shiftDown(0);
        return ret;
    }

    /**
     * 获取最大值的索引
     */
    public int extractMaxIndex() {
        assert (count > 0);
        int ret = indexes[0];
        swap(indexes, 0, count - 1);
        count--;
        shiftDown(0);
        return ret;
    }

    /**
     * 将最大索引堆中索引为i的元素修改为newData
     */
    public void set(int i, T newData) {
        assert (i >= 0 && i <= capacity);
        data[i] = newData;
        for (int j = 0; j < count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    /**
     * 注意此下标从0开始的,所以条件为 2*k+1 <count,非<=
     */
    private void shiftDown(int k) {
        while (2 * k + 1 < count) {
            int j = 2 * k + 1;
            if (j + 1 < count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swap(indexes, k, j);
            reverseIndexes[indexes[k]] = k;
            reverseIndexes[indexes[j]] = j;
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 0 && greaterParent(k)) {
            swap(indexes, k, (k - 1) / 2);
            reverseIndexes[indexes[k]] = k;
            reverseIndexes[indexes[(k - 1) / 2]] = (k - 1) / 2;
            k = (k - 1) / 2;
        }
    }

    private boolean greaterParent(int k) {
        return data[indexes[k]].compareTo(data[indexes[(k - 1) / 2]]) > 0;
    }

    private void swap(int[] array, int idx, int idy) {
        int tmp = array[idx];
        array[idx] = array[idy];
        array[idy] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = RandomUtil.generateRandomArray(20, 0, 100);
        MaxIndexHeap maxIndexHeap = new MaxIndexHeap(20);
        for (int i = 0; i < array.length; i++) {
            maxIndexHeap.insert(i, array[i]);
        }
        System.out.println(Arrays.toString(maxIndexHeap.data));
        for (int i = 0; i < array.length; i++) {
            System.out.print(maxIndexHeap.extractMax() + " ");
        }
        System.out.println("=================");
        System.out.println("=================");
        Integer[] array1 = RandomUtil.copyArray(array);
        maxIndexHeap = new MaxIndexHeap(20);
        for (int i = 0; i < array.length; i++) {
            maxIndexHeap.insert(i, array1[i]);
        }
        System.out.println(Arrays.toString(maxIndexHeap.data));
        for (int i = 0; i < array.length; i++) {
            System.out.print(maxIndexHeap.extractMaxIndex() + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
        }
    }

}
