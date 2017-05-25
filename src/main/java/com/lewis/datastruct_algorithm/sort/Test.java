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
        int size = 1000000;
        int bounds =100;
        Integer[] array = RandomUtil.generateRandomArray(size, 0, bounds);
        Integer[] array2 = RandomUtil.copyArray(array);
        Integer[] array3 = RandomUtil.copyArray(array);
        Integer[] array4 = RandomUtil.copyArray(array);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,array3);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,array);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_2WAYS,array2);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_3WAYS,array4);
        System.out.println();
        /*Integer[] arr = RandomUtil.generateNearlyOrderedArray(size, 1000000000);
        Integer[] arr1 = RandomUtil.copyArray(arr);
        Integer[] arr2 = RandomUtil.copyArray(arr);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,arr);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,arr1);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_2WAYS,arr2);*/
    }
}
