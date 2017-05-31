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

    protected T[] data;

    /**
     * 索引：指向数据data
     */
    private int[] indexes;

    protected int count;

    protected int capacity;

    public MaxIndexHeap(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T item) {
        assert (count + 1 <= capacity);
        data[count] = item;
        shiftUp(count);
        count++;
    }

    public T extractMax() {
        assert (count > 0);
        T ret = data[0];
        swap(data, 0, count - 1);
        count--;
        shiftDown(0);
        return ret;
    }

    /**
     * 注意此下标从0开始的,所以条件为 2*k+1 <count,非<=
     */
    private void shiftDown(int k) {
        while (2 * k + 1 < count) {
            int j = 2 * k + 1;
            if (j + 1 < count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 0 && greaterParent(k)) {
            swap(data, k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private boolean greaterParent(int k) {
        return data[k].compareTo(data[(k - 1) / 2]) > 0;
    }

    private void swap(T[] array, int idx, int idy) {
        T tmp = array[idx];
        array[idx] = array[idy];
        array[idy] = tmp;
    }

    public static void main(String[] args) {
        Integer[] array = RandomUtil.generateRandomArray(16, 0, 100);
        MaxIndexHeap maxIndexHeap = new MaxIndexHeap(10);
        for (int i = 0; i < array.length; i++) {
            maxIndexHeap.insert(array[i]);
        }
        System.out.println(Arrays.toString(maxIndexHeap.data));

        for (int i = 0; i < array.length; i++) {
            System.out.print(maxIndexHeap.extractMax() + " ");
        }
    }

}
