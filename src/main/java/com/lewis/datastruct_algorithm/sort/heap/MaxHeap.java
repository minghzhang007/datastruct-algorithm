package com.lewis.datastruct_algorithm.sort.heap;

/**
 * 最大堆
 *
 * @author zmh46712
 * @version Id: MaxHeap, v 0.1 2017/5/26 11:21 zmh46712 Exp $
 */
public class MaxHeap<T extends Comparable> {

    public MaxHeap(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    private T[] items;

    private int capacity;

    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T getMax() {
        assert count > 0;
        return items[1];
    }

    public void insert(T item) {
        assert count + 1 < capacity;
        items[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public T extractMax() {
        assert count > 0;
        T ret = items[1];
        swap(items, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while (count >= 2 * k) {
            int j = 2 * k; //此轮循环中，items[k]和items[j]交换位置
            if (j + 1 <= count && items[j + 1].compareTo(items[2 * k]) > 0) {
                j++;
            }
            if (items[k].compareTo(items[j]) >= 0) {
                break;
            }
            swap(items, k, j);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && items[k / 2].compareTo(items[k]) < 0) {
            swap(items, k / 2, k);
            k = k / 2;
        }
    }

    private void swap(T[] array, int idx, int idy) {
        T tmp = array[idx];
        array[idx] = array[idy];
        array[idy] = tmp;
    }
}
