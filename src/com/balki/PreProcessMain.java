package com.balki;

import com.balki.data.FileType;
import com.balki.util.FileOperations;
import com.balki.util.Util;

import java.io.IOException;
import java.util.*;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public class PreProcessMain {
    private static final int MIN = 100;
    private static final int MAX = 999;

    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int count : Util.COUNTS) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(generateRandomNumber());
            }

            map.put(count, list);
        }

        for(FileType fileType : FileType.values()){
            for(int count : Util.COUNTS) {
                String fileName = FileOperations.getFileName(fileType, count);

                List<Integer> list = new ArrayList<>(map.get(count));

                switch (fileType){
                    case RANDOM:{
                        break;
                    }
                    case ORDERED:{
                        Collections.sort(list);
                        break;
                    }
                    case REVERSED_ORDERED:{
                        Collections.sort(list);
                        Collections.reverse(list);
                        break;
                    }
                }

                FileOperations.writeFile(fileName, list);
            }
        }
    }

    private static int generateRandomNumber(){
        int min = MIN;
        int max = MAX;

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }


}
