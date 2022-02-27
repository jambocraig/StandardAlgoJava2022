package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static sorting.SortAlgorithms.*;

public class SortTester {
    public static void main(String[] args) throws IOException {
        //testing declarations
        long start, stop, duration;
        System.out.println("Sort tester");
        final int SIZE = 100_000;
        int[] arr = new int[SIZE];
        populate(arr);
        writeToFile(arr,"data.txt");
        start = System.currentTimeMillis();
        //quicksort(arr);
        quicksort2(arr, 0, arr.length - 1);
        stop = System.currentTimeMillis();
        duration = stop - start;
        System.out.println(duration);
        //System.out.println(Arrays.toString(arr));
    }

    private static void writeToFile(int[] arr, String s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(s));
        for (int value:arr) {
            bw.write(value + ",");
        }
        bw.close();
    }
}
