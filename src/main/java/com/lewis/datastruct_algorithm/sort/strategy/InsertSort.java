package com.lewis.datastruct_algorithm.sort.strategy;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.util.RandomUtil;

/**
 * 插入排序算法
 *
 * @author zmh46712
 * @version Id: InsertSort, v 0.1 2017/5/23 14:23 zmh46712 Exp $
 */
public class InsertSort implements Sort {
    // 0 1 2 3 4 5 6
    // 4 1 5 3 6 9 7
    public int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            //寻找元素array[i]的合适的插入位置
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    //每次比较符合条件，则交换两个元素位置
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
