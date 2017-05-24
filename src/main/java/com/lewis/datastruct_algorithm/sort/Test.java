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
        int[] array = RandomUtil.generateRandomArray(1000000, 0, 100000);
        int[] array1 = RandomUtil.copyArray(array);
        int[] array2 = RandomUtil.copyArray(array);
        int[] array3 = RandomUtil.copyArray(array);
        SortTestUtil.testSort(SortEnum.INSERT_SORT,array);
        SortTestUtil.testSort(SortEnum.INSERT_SORT_ADVANCE,array1);
        SortTestUtil.testSort(SortEnum.SELECTION_SORT,array2);
        SortTestUtil.testSort(SortEnum.MERGE_SORT,array3);
    }
}
