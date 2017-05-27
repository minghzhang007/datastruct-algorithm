package com.lewis.datastruct_algorithm.sort.strategy.advanced;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.heap.MaxHeap;

/**
 * 使用最大堆来排序 将数组的元素一个一个的插入堆中来构建最大堆
 *
 * @author zmh46712
 * @version Id: HeapSort, v 0.1 2017/5/27 10:57 zmh46712 Exp $
 */
public class HeapSort implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        MaxHeap maxHeap = new MaxHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = maxHeap.extractMax();
        }
        return array;
    }
}
