package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.heap.MaxHeap;

/**
 * 使用最大堆排序 使用一个数组直接构建一个最大堆
 * @author zmh46712
 * @version Id: HeapSortAdvance, v 0.1 2017/5/27 11:07 zmh46712 Exp $
 */
public class HeapSortAdvance implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = maxHeap.extractMax();
        }
        return array;
    }
}
