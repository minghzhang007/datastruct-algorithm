package com.lewis.datastruct_algorithm.sort.strategy;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.util.RandomUtil;

/**
 * 选择排序
 *
 * @author zmh46712
 * @version Id: SelectionSort, v 0.1 2017/5/23 14:22 zmh46712 Exp $
 */
public class SelectionSort implements Sort {

    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            //minIndex表示第i轮的最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return array;
    }
}
