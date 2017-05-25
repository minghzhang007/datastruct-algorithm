package com.lewis.datastruct_algorithm.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zmh46712
 * @version Id: RandomUtil, v 0.1 2017/5/23 11:31 zmh46712 Exp $
 */
public class RandomUtil {
    private static final Random random = new Random();

    public static Integer[] generateRandomArray(int size, int smallBound, int bigBound) {
        Integer[] array = new Integer[size];
        int range = bigBound - smallBound + 1;
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bigBound) % range + smallBound;
        }
        return array;
    }

    public static Integer[] generateNearlyOrderedArray(int size, int swapTimes) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        for (int i = 0; i <= swapTimes; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            swap(array, idx1, idx2);
        }
        return array;
    }

    public static void swap(Integer[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static Integer[] copyArray(Integer[] array) {
        Integer[] newArray = new Integer[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public static void main(String[] args) {
        Integer[] ints = generateRandomArray(100, 50, 60);
        System.out.println(Arrays.toString(ints));

        Integer[] ints1 = generateNearlyOrderedArray(10, 1);
        System.out.println(Arrays.toString(ints1));
    }
}
