package com.lewis.datastruct_algorithm.sort;

import com.lewis.datastruct_algorithm.util.RandomUtil;
import com.lewis.datastruct_algorithm.util.TestSortUtil;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Test {
    public static void main(String[] args) throws MyException {
        testInsertSort();
    }

    public static void testInsertSort() throws MyException {
        int[] array = RandomUtil.generateRandomArray(10000, 10, 100000);
        int[] array1 = RandomUtil.copyArray(array);
        TestSortUtil.testSort(SortEnum.INSERT_SORT,array);
        TestSortUtil.testSort(SortEnum.INSERT_SORT_ADVANCE,array1);
    }
}
