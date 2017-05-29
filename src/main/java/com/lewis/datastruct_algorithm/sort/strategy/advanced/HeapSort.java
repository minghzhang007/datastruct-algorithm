package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 原地堆排序，不适用额外的堆空间
 *
 * @author zmh46712
 * @version Id: HeapSort1, v 0.1 2017/5/27 13:50 zmh46712 Exp $
 */
public class HeapSort implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {

        int n = array.length;
        //索引从0开始
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(array, i, 0);
            shiftDown(array, i, 0);
        }
        return array;
    }

    /**
     * 下标从0开始的
     *
     * @param array
     * @param n
     * @param k
     */
    private void shiftDown(Comparable[] array, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && array[j + 1].compareTo(array[j]) > 0) {
                j++;
            }
            if (array[k].compareTo(array[j]) >= 0) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }
}
