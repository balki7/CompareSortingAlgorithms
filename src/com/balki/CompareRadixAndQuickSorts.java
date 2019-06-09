package com.balki;

import com.balki.compare.CompareSorts;
import com.balki.sort.QuickSort;
import com.balki.sort.RadixSort;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public class CompareRadixAndQuickSorts {

    public static void main(String[] args) throws Exception {
        CompareSorts compareSorts = new CompareSorts();
        compareSorts.compare(new RadixSort(), new QuickSort());
    }
}
