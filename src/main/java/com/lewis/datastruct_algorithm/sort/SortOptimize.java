package com.lewis.datastruct_algorithm.sort;

import java.util.Random;

/**
 * @author zmh46712
 * @version Id: SortOptimize, v 0.1 2017/5/25 9:44 zmh46712 Exp $
 */
public interface SortOptimize {

    /**
     * 使用插入排序 来排序数组array中下标从l到r的部分
     *
     * @param array 待排序数组
     * @param leftIndex     排序起始位置
     * @param rightIndex     排序结束为止
     */
    default void insertSort(Comparable[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            Comparable e = array[i];
            int j;
            for (j = i; j > leftIndex && array[j - 1].compareTo(e) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;
        }
    }

    /**
     * 对于小规模数组，判断是否使用插入排序来优化效率
     */
    default boolean isUseInsertSortOpt(int leftIndex, int rightIndex) {
        return rightIndex - leftIndex + 1 < 47;
    }

    /**
     * 交换数组array下标idx1和idx2的元素
     */
    default void swap(Comparable[] array, int idx1, int idx2) {
        Comparable temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    default int random(int leftIndex, int rightIndex) {
        return (int) (Math.random() * (rightIndex - leftIndex + 1)) + leftIndex;
    }

}
