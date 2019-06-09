package com.balki.util;

import com.balki.data.FileType;

import java.io.*;
import java.util.List;

/**
 * @author Balkı
 * @since 23/03/2019
 */
public class FileOperations {
    public static void writeFile(String file, List<Integer> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        for (Integer number : list) {
            bw.write(String.valueOf(number.intValue()));
            bw.write("\n");
        }

        bw.close();
    }

    public static void writeFile(String file, String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(content);
        bw.close();
    }

    public static int[] readFile(String file, int count) throws IOException {
        int[] numbers = new int[count];
        int counter = -1;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            numbers[++counter] = Integer.parseInt(sCurrentLine);
        }
        return numbers;
    }

    public static String getFileName(FileType type, long count) {
        return "numbers_" + type.name().toLowerCase() + '_' + count + ".txt";
    }
}
