package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.MyException;
import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.SortEnum;
import com.lewis.datastruct_algorithm.util.RandomUtil;
import com.lewis.datastruct_algorithm.util.SortTestUtil;

import java.util.Arrays;

/**原地堆排序，不适用额外的堆空间
 * @author zmh46712
 * @version Id: HeapSort1, v 0.1 2017/5/27 13:50 zmh46712 Exp $
 */
public class HeapSort1 implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {

        int n = array.length - 1;
        //索引从0开始
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(array, n, i);
        }
        System.out.println(Arrays.toString(array));
        for (int i = n; i > 0; i--) {
            swap(array, i, 0);
            shiftDown(array, i, 0);
        }
        return array;
    }

    private void shiftDown(Comparable[] array, int n, int k) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j + 1 <= n && array[j + 1].compareTo(array[j]) > 0) {
                j++;
            }
            if (array[k].compareTo(array[j]) >= 0) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

    public static void main(String[] args) throws MyException {
        Integer[] array = { 15, 91, 84, 35, 42, 87, 57, 47, 32, 60 };
        SortTestUtil.testSort(SortEnum.HEAP_SORT1, array);
    }
}
