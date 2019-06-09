package com.balki;

import com.balki.compare.CompareSorts;
import com.balki.sort.*;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public class CompareSelectionAndBubbleSorts {

    public static void main(String[] args) throws Exception {
        CompareSorts compareSorts = new CompareSorts();
        compareSorts.compare(new SelectionSort(), new BubbleSort());
    }
}
