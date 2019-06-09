package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public class SelectionSort extends AbstractSort {
    private int smallest(int a[], int i) {
        int small = a[i];
        int pos = i;

        for (int j = i + 1; j < a.length; j++) {
            incComparisons();
            if (a[j] < small) {
                incAssignments();
                small = a[j];
                pos = j;
            }
        }
        return pos;
    }

    @Override
    public void sort(int[] arr) {
        int temp;
        int pos;

        for (int i = 0; i < (arr.length - 1); i++) {
            pos = smallest(arr, i);
            incAssignments();
            temp = arr[i];
            incAssignments();
            arr[i] = arr[pos];
            incAssignments();
            arr[pos] = temp;
        }
    }
}
