package com.lewis.datastruct_algorithm.sort.strategy;

import com.lewis.datastruct_algorithm.sort.Sort;

/**
 * 插入排序的改进版本
 * Created by Administrator on 2017/5/23.
 */
public class InsertSortAdvanced implements Sort {

    // 0 1 2 3 4 5 6
    // 4 1 5 3 6 9 7
    public Comparable[] sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable e = array[i];
            //j保存元素e应该插入的位置
            int j;
            for (j = i; j > 0 && array[j - 1].compareTo(e) > 0; j--) {
                array[j] = array[j - 1];
            }
            //将元素e放入位置j处
            array[j] = e;
        }
        return array;
    }

}
