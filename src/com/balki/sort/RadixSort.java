package com.balki.sort;


/**
 * @author Balkı
 * @since 23/03/2019
 */
public class RadixSort extends AbstractSort {
    private int largest(int a[]) {
        int larger = a[0];

        for (int i = 1; i < a.length; i++) {
            incComparisons();
            if (a[i] > larger) {
                larger = a[i];
            }
        }

        return larger;
    }

    private void radixSort(int arr[]) {
        int bucket[][] = new int[arr.length][arr.length];
        int bucketCount[] = new int[arr.length];
        int remainder;
        int NOP = 0, divisor = 1, pass;

        int larger = largest(arr);
        while (larger > 0) {
            NOP++;
            larger /= arr.length;
        }

        int i=0;
        for (pass = 0; pass < NOP; pass++) // Initialize the buckets
        {
            for (i = 0; i < arr.length; i++)
                bucketCount[i] = 0;
            for (i = 0; i < arr.length; i++) {
                // sort the numbers according to the digit at passth place
                remainder = (arr[i] / divisor) % arr.length;
                bucket[remainder][bucketCount[remainder]] = arr[i];
                bucketCount[remainder] += 1;
            }
            // collect the numbers after PASS pass
            i = 0;
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < bucketCount[k]; j++) {
                    arr[i] = bucket[k][j];
                    i++;
                }
            }
            divisor *= arr.length;
        }
    }

    @Override
    public void sort(int[] arr) {
        radixSort(arr);
    }
}
