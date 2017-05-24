package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;

/**
 * 归并排序
 * @author zmh46712
 * @version Id: MegerSort, v 0.1 2017/5/23 14:24 zmh46712 Exp $
 */
public class MergeSort implements Sort {

    public int[] sort(int[] array) {
        int[] tmp = new int[array.length];
        sort(array, tmp, 0, array.length - 1);

        return array;
    }

    /**
     * 递归的使用归并排序，对array[left...right]的范围进行排序
     * @param array 待排序的数组
     * @param tempArray 临时辅助空间
     * @param left  排序的起始位置
     * @param right 排序的结束为止
     */
    private void sort(int[] array, int[] tempArray, int left, int right) {
        if (left >= right)
            return;
        int midIndex = (right + left) / 2;
        sort(array, tempArray, left, midIndex);
        sort(array, tempArray, midIndex + 1, right);
        merge(array, tempArray, left, midIndex, right);
    }

    /**
     * 将数组array[left...midIndex]的部分和数组array[midIndex+1...right]的部分进行归并
     * @param array 待归并的数组
     * @param tempArray 临时辅助空间
     * @param left  第一部分归并的起始位置
     * @param midIndex 第一部分归并的结束位置
     * @param right 第二部分归并的结束位置
     */
    private void merge(int[] array, int[] tempArray, int left, int midIndex, int right) {
        int i = left;
        int j = midIndex + 1;
        int k = 0;
        while (i <= midIndex && j <= right) {
            if (array[i] < array[j]) {
                tempArray[k++] = array[i];
                i++;
            } else {
                tempArray[k++] = array[j];
                j++;
            }
        }
        while (i <= midIndex) {
            tempArray[k++] = array[i++];
        }
        while (j <= right) {
            tempArray[k++] = array[j++];
        }
        for (int l = 0; l < k; l++) {
            array[left + l] = tempArray[l];
        }
    }

}
