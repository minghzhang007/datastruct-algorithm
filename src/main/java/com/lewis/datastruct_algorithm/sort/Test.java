package com.lewis.datastruct_algorithm.sort;

import com.lewis.datastruct_algorithm.util.RandomUtil;
import com.lewis.datastruct_algorithm.util.SortTestUtil;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Test {
    public static void main(String[] args) throws MyException {
        testInsertSort();
    }


    public static void testInsertSort() throws MyException {
        Integer[] array = RandomUtil.generateRandomArray(10000000, 0, 1000000000);
        Integer[] array2 = RandomUtil.copyArray(array);
        Integer[] array3 = RandomUtil.copyArray(array);
        //SortTestUtil.testSort(SortEnum.SELECTION_SORT,array2);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,array3);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,array);
        System.out.println();
        Integer[] arr = RandomUtil.generateNearlyOrderedArray(10000000, 1000000000);
        Integer[] arr1 = RandomUtil.copyArray(arr);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,arr);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,arr1);
    }
}
