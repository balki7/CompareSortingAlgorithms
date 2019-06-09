package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public class QuickSort extends AbstractSort {
    private int partition(int arr[], int low, int high) {
        incAssignments();
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            incComparisons();
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                incAssignments();
                int temp = arr[i];
                incAssignments();
                arr[i] = arr[j];
                incAssignments();
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        incAssignments();
        int temp = arr[i+1];
        incAssignments();
        arr[i+1] = arr[high];
        incAssignments();
        arr[high] = temp;

        return i+1;
    }

    private void quickSort(int a[], int beg, int end) {
        int loc;
        if (beg < end) {
            loc = partition(a, beg, end);
            if((loc-1) != end) {
                quickSort(a, beg, loc - 1);
            }
            quickSort(a, loc + 1, end);
        }
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
