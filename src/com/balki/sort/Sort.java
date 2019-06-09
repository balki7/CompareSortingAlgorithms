package com.balki.sort;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public interface Sort {
    void sort(int[] arr);

    long getNumberOfComparisons();

    long getNumberOfAssignments();

    void reset();
}
