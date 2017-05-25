package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;

/**
 * 三路快速排序
 * @author zmh46712
 * @version Id: QuickSort3Ways, v 0.1 2017/5/25 15:25 zmh46712 Exp $
 */
public class QuickSort3Ways implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 递归的使用快速排序 排序array[leftIndex...rightIndex]范围
     */
    private void quickSort(Comparable[] array, int leftIndex, int rightIndex) {
        if (isUseInsertSortOpt(leftIndex,rightIndex)) {
            insertSort(array,leftIndex,rightIndex);
            return;
        }
        swap(array,leftIndex,random(leftIndex,rightIndex));
        Comparable v = array[leftIndex];
        int lt = leftIndex; //array[leftIndex+1...lt] < v;
        int gt = rightIndex + 1; //array[gt...rightIndex] > v;
        int i = leftIndex + 1; //array[lt+1,i == v
        while (i < gt) {
            if (array[i].compareTo(v) < 0) {
                swap(array, i, lt + 1);
                i++;
                lt++;
            } else if (array[i].compareTo(v) > 0) {
                swap(array, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(array,leftIndex,lt);

        quickSort(array,leftIndex,lt-1);
        quickSort(array,gt,rightIndex);
    }
}
