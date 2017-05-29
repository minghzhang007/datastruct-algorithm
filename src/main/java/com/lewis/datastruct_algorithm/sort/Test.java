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
        int size = 100000;
        int bounds =1000000;
        Integer[] array = RandomUtil.generateRandomArray(size, 0, bounds);
        Integer[] array2 = RandomUtil.copyArray(array);
        Integer[] array3 = RandomUtil.copyArray(array);
        Integer[] array4 = RandomUtil.copyArray(array);
        Integer[] array5 = RandomUtil.copyArray(array);
        Integer[] array6 = RandomUtil.copyArray(array);
        Integer[] array7 = RandomUtil.copyArray(array);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,array);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_2WAYS,array2);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,array3);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_3WAYS,array4);
        SortTestUtil.testSort(SortEnum.HEAP_SORT1,array7);
        SortTestUtil.testSort(SortEnum.HEAP_SORT_ADVANCE,array6);
        SortTestUtil.testSort(SortEnum.HEAP_SORT,array5);

        System.out.println("NearlyOrderedArray");
        array = RandomUtil.generateNearlyOrderedArray(size,100);
        array2 = RandomUtil.copyArray(array);
        array3 = RandomUtil.copyArray(array);
        array4 = RandomUtil.copyArray(array);
        array5 = RandomUtil.copyArray(array);
        array6 = RandomUtil.copyArray(array);
        array7 = RandomUtil.copyArray(array);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,array);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_2WAYS,array2);
        SortTestUtil.testSort(SortEnum.QUICK_SORT,array3);
        SortTestUtil.testSort(SortEnum.QUICK_SORT_3WAYS,array4);
        SortTestUtil.testSort(SortEnum.HEAP_SORT1,array7);
        SortTestUtil.testSort(SortEnum.HEAP_SORT_ADVANCE,array6);
        SortTestUtil.testSort(SortEnum.HEAP_SORT,array5);

    }
}
