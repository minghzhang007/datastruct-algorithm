package com.lewis.datastruct_algorithm.sort.heap;

/**
 * 最大堆
 *
 * @author zmh46712
 * @version Id: MaxHeap, v 0.1 2017/5/26 11:21 zmh46712 Exp $
 */
public class MaxHeap<T extends Comparable> {

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 使用数组构建一个最大堆
     */
    public MaxHeap(T[] array) {
        data = (T[]) new Comparable[array.length + 1];
        capacity = array.length;
        for (int i = 0; i < array.length; i++) {
            data[i + 1] = array[i];
        }
        count = array.length;
        for (int i = count/2; i > 0 ; i--) {
            shiftDown(i);
        }
    }

    protected T[] data;

    private int   capacity;

    protected int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T getMax() {
        assert count > 0;
        return data[1];
    }

    public void insert(T item) {
        assert count + 1 < capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public T extractMax() {
        assert count > 0;
        T ret = data[1];
        swap(data, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while (count >= 2 * k) {
            int j = 2 * k; //此轮循环中，data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[2 * k]) > 0) {
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
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(data, k / 2, k);
            k = k / 2;
        }
    }

    private void swap(T[] array, int idx, int idy) {
        T tmp = array[idx];
        array[idx] = array[idy];
        array[idy] = tmp;
    }
}
