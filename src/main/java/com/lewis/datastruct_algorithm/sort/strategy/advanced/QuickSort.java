package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;

/**
 * 快速排序
 *
 * @author zmh46712
 * @version Id: QuickSort, v 0.1 2017/5/23 14:24 zmh46712 Exp $
 */
public class QuickSort implements Sort {

    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);

        return array;
    }

    /**
     * 使用快速排序 排序array[leftIndex...rightIndex]
     */
    private void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex + 1 < 47) {
            insertSort(array, leftIndex, rightIndex);
            return;
        }
        int pIndex = partition(array, leftIndex, rightIndex);
        //排序array[leftIndex...pIndex-1]的部分
        quickSort(array, leftIndex, pIndex - 1);
        //排序array[pIndex+1...rightIndex]的部分
        quickSort(array, pIndex + 1, rightIndex);
    }

    /**
     * 返回下标pIndex,使得
     * array[leftIndex...pIndex-1] < array[pIndex]
     * array[pIndex+1...rightIndex] > array[pIndex]
     *   ********************************
     *   *v* < v    * >v    *
     *   ********************************
     *   l     < v  j    >v
     * 
     * @param array      待排序数组
     * @param leftIndex  排序的起始下标
     * @param rightIndex 排序的结束下标
     * @return 下标pIndex
     */
    private int partition(int[] array, int leftIndex, int rightIndex) {
        //随机取一个标准v,使其和leftIndex交换位置
        swap(array, leftIndex, random(leftIndex, rightIndex));
        int v = array[leftIndex];
        //下边j代表小于标准v的最右边界 array[leftIndex+1...j] < v;  array[j+1...i) > v
        int j = leftIndex;
        //下标i代表正在处理的元素下标
        int i;
        for (i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] < v) {
                swap(array, i, ++j);
            }
        }
        swap(array, leftIndex, j);
        return j;
    }
}
