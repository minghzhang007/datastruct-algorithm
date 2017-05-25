package com.lewis.datastruct_algorithm.test;

import com.lewis.datastruct_algorithm.sort.SortOptimize;
import com.lewis.datastruct_algorithm.util.RandomUtil;

import java.util.Arrays;

/**
 * @author zmh46712
 * @version Id: SortOptimizeTest, v 0.1 2017/5/25 9:56 zmh46712 Exp $
 */
public class SortOptimizeTest {
    public static void main(String[] args) {
        SortOptimize sortOptimize = new SortOptimize() {
        };
        int[] array = RandomUtil.generateRandomArray(10, 0, 20);
        System.out.println(Arrays.toString(array));
        sortOptimize.insertSort(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }
}
