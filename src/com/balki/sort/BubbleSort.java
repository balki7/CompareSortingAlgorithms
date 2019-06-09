package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public class BubbleSort extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                incComparisons();
                if (arr[i] < arr[j]) {
                    incAssignments();
                    int temp = arr[i];
                    incAssignments();
                    arr[i] = arr[j];
                    incAssignments();
                    arr[j] = temp;
                }
            }
        }
    }
}
