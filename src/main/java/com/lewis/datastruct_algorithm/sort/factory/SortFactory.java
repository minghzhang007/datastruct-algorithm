package com.lewis.datastruct_algorithm.sort.factory;

import com.lewis.datastruct_algorithm.sort.Sort;
import com.lewis.datastruct_algorithm.sort.SortEnum;
import com.lewis.datastruct_algorithm.sort.strategy.*;
import com.lewis.datastruct_algorithm.sort.strategy.advanced.MegerSort;
import com.lewis.datastruct_algorithm.sort.strategy.advanced.QuickSort;

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
        return createSort(SortEnum.MEGER_SORT);
    }

    public static Sort createQuickSort() {
        return createSort(SortEnum.QUICK_SORT);
    }

    public static Sort createInsertSortAdvance() {
        return createSort(SortEnum.INSERT_SORT_ADVANCE);
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
            case MEGER_SORT:
                return new MegerSort();
            case QUICK_SORT:
                return new QuickSort();
            case INSERT_SORT_ADVANCE:
                return new InsertSortAdvanced();
            default:
                return new QuickSort();
        }
    }
}
