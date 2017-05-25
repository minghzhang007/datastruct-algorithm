package com.lewis.datastruct_algorithm.util;

import com.lewis.datastruct_algorithm.sort.MyException;
import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.SortEnum;
import com.lewis.datastruct_algorithm.sort.factory.SortFactory;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/5/23.
 */
public class SortTestUtil {

    public static void testSort(SortEnum sortEnum, Comparable[] array) throws MyException {
        testSort(sortEnum, array, false);
    }

    public static void testSort(SortEnum sortEnum, Comparable[] array, boolean needPrintArrayAfterSorted) throws MyException {
        Sort sortStrategy = SortFactory.createSort(sortEnum);
        long begin = System.currentTimeMillis();
        sortStrategy.sort(array);
        System.out.println(sortEnum + " costTime: " + (System.currentTimeMillis() - begin) + " MS");
        if (needPrintArrayAfterSorted) {
            System.out.println(Arrays.toString(array));
        }
        if (!isSorted(array)) {
            System.out.println(sortEnum + " 数组元素排序不对！");
        }
    }

    private static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0)
                return false;
        }
        return true;
    }

}
