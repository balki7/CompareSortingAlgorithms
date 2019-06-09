package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public class MergeSort extends AbstractSort {
    private void merge(int[] arr, int beg, int mid, int end) {
        int l = mid - beg + 1;
        int r = end - mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        for (int i = 0; i < l; ++i) {
            incAssignments();
            leftArray[i] = arr[beg + i];
        }

        for (int j = 0; j < r; ++j) {
            incAssignments();
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = beg;
        while (i < l && j < r) {
            incComparisons();
            incAssignments();
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < l) {
            incAssignments();
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < r) {
            incAssignments();
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void sort(int arr[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            sort(arr, beg, mid);
            sort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    @Override
    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }
}
