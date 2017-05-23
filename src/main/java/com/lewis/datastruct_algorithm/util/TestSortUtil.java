package com.lewis.datastruct_algorithm.util;

import com.lewis.datastruct_algorithm.sort.MyException;
import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.SortEnum;
import com.lewis.datastruct_algorithm.sort.factory.SortFactory;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/5/23.
 */
public class TestSortUtil {

    public static void testSort(SortEnum sortEnum, int[] array) throws MyException {
        Sort sortStrategy = SortFactory.createSort(sortEnum);
        long begin = System.currentTimeMillis();
        sortStrategy.sort(array);
        System.out.println(sortEnum + " costTime: " + (System.currentTimeMillis() - begin) +" MS");
        if (!isSorted(array)) {
            throw new MyException("数组排序不对！");
        }
        //System.out.println(Arrays.toString(array));
    }


    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

}
