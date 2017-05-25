package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;

/**
 * 双路快速排序
 *
 * @author zmh46712
 * @version Id: QuickSort2Ways, v 0.1 2017/5/25 15:24 zmh46712 Exp $
 */
public class QuickSort2Ways implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {

        quickSort(array, 0, array.length - 1);

        return array;
    }

    /**
     * 递归的使用快速排序 对array[leftIndex...rightIndex]范围排序
     */
    private void quickSort(Comparable[] array, int leftIndex, int rightIndex) {
        if (isUseInsertSortOpt(leftIndex, rightIndex)) {
            insertSort(array, leftIndex, rightIndex);
            return;
        }
        int pIndex = partition(array, leftIndex, rightIndex);
        quickSort(array, leftIndex, pIndex - 1);
        quickSort(array, pIndex + 1, rightIndex);
    }

    /**
     * 双路快速排序的partition
     * 使得返回的pIndex 满足 array[leftIndex...pIndex-1] < array[pIndex] && array[pIndex] < array[pIndex+1...rightIndex]
     */
    private int partition(Comparable[] array, int leftIndex, int rightIndex) {
        Comparable v = array[leftIndex];
        //array[leftIndex+1...i) < v  < array(j,r]
        int i = leftIndex + 1;
        int j = rightIndex;
        while (true) {
            while (i <= rightIndex && array[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= leftIndex + 1 && array[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, leftIndex, j);
        return j;
    }
}
