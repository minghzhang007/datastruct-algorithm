package com.lewis.datastruct_algorithm.sort.factory;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.SortEnum;
import com.lewis.datastruct_algorithm.sort.strategy.*;
import com.lewis.datastruct_algorithm.sort.strategy.advanced.*;

/**
 * @author zmh46712
 * @version Id: SortFactory, v 0.1 2017/5/23 14:21 zmh46712 Exp $
 */
public class SortFactory {

    public static Sort createBubbleSort() {
        return createSort(SortEnum.BUBBLE_SORT);
    }

    public static Sort createInsertSort() {
        return createSort(SortEnum.INSERT_SORT);
    }

    public static Sort createSelectionSort() {
        return createSort(SortEnum.SELECTION_SORT);
    }

    public static Sort createShellSort() {
        return createSort(SortEnum.SHELL_SORT);
    }

    public static Sort createMegerSort() {
        return createSort(SortEnum.MERGE_SORT);
    }

    public static Sort createQuickSort() {
        return createSort(SortEnum.QUICK_SORT);
    }

    public static Sort createInsertSortAdvance() {
        return createSort(SortEnum.INSERT_SORT_ADVANCE);
    }

    public static Sort createQuickSort2Ways() {
        return createSort(SortEnum.QUICK_SORT_2WAYS);
    }

    public static Sort createQuickSort3Ways() {
        return createSort(SortEnum.QUICK_SORT_3WAYS);
    }

    public static Sort createSort(SortEnum sortEnum) {
        switch (sortEnum) {
            case BUBBLE_SORT:
                return new BubbleSort();
            case INSERT_SORT:
                return new InsertSort();
            case SELECTION_SORT:
                return new SelectionSort();
            case SHELL_SORT:
                return new ShellSort();
            case MERGE_SORT:
                return new MergeSort();
            case QUICK_SORT:
                return new QuickSort();
            case QUICK_SORT_2WAYS:
                return new QuickSort2Ways();
            case QUICK_SORT_3WAYS:
                return new QuickSort3Ways();
            case INSERT_SORT_ADVANCE:
                return new InsertSortAdvanced();
            case HEAP_SORT:
                return new HeapSort();
            case HEAP_SORT_ADVANCE:
                return new HeapSortAdvance();
            case HEAP_SORT1:
                return new HeapSort1();
            default:
                return new QuickSort();
        }
    }
}
