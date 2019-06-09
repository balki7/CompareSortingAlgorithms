package com.balki.compare;

import com.balki.data.FileType;
import com.balki.sort.Sort;
import com.balki.util.FileOperations;
import com.balki.util.TimeOperations;
import com.balki.util.Util;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public class CompareSorts {
    public void compare(Sort sort1, Sort sort2) throws Exception {
        for(FileType fileType : FileType.values()) {
            for (int count : Util.COUNTS) {
                String fileName = FileOperations.getFileName(fileType, count);
                int[] numbers = FileOperations.readFile(fileName, count);

                for (int i = 0; i < Util.RETRY_COUNT; i++) {
                    int[] list1 = numbers.clone();
                    int[] list2 = numbers.clone();
                    sort1.reset();
                    sort2.reset();

                    if (i != 0) {
                        Util.report(sort1, sort2, fileType, "\n" + count + ";" + i + ";");
                    }

                    TimeOperations.startTimer();
                    sort1.sort(list1);
                    long duration1 = TimeOperations.stopTimer();
                    if (i != 0) {
                        Util.report(sort1, sort2, fileType, duration1 + ";" + sort1.getNumberOfAssignments() + ";" + sort1.getNumberOfComparisons());
                    }

                    TimeOperations.startTimer();
                    sort2.sort(list2);
                    long duration2 = TimeOperations.stopTimer();
                    if (i != 0) {
                        Util.report(sort1, sort2, fileType, ";" + duration2 + ";" + sort2.getNumberOfAssignments() + ";" + sort2.getNumberOfComparisons());
                    }
                }
            }
        }
    }
}

