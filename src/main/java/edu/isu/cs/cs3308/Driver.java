package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.algorithms.ArraySearch;
import edu.isu.cs.cs3308.algorithms.impl.BinarySearch;
import edu.isu.cs.cs3308.algorithms.impl.LinearSearch;
import edu.isu.cs.cs3308.algorithms.impl.RecursiveBinarySearch;
import edu.isu.cs.cs3308.algorithms.impl.RecursiveLinearSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Driver class for the experimental simulator.
 * @author Isaac Griffith
 */
public class Driver {

    public static void main(String args[]) {
        // Creation of array and Declaration of search and time variables
        Integer[] arr1 = generateRandomArray(9500);
        ArraySearch linear = new LinearSearch();
        ArraySearch binary = new BinarySearch();
        ArraySearch binaryRec = new RecursiveBinarySearch();
        ArraySearch linearRec = new RecursiveLinearSearch();
        long[] linearTimes = new long[10];
        long[] binaryTimes = new long[10];
        long[] recLinearTimes = new long[10];
        long[] recBinaryTimes = new long[10];
        long holdStart;
        long holdEnd;
        // Storing iterative linear search times in linearTimes[]
        for (int i = 0; i < linearTimes.length; i++){
            holdStart = System.nanoTime();
            linear.search(arr1, 2500);
            holdEnd = System.nanoTime();
            linearTimes[i] += holdEnd - holdStart;
        }
        // Storing recursive linear search times in recLinearTimes[]
        for (int i = 0; i < recLinearTimes.length; i++){
            holdStart = System.nanoTime();
            linearRec.search(arr1, 2500);
            holdEnd = System.nanoTime();
            recLinearTimes[i] += holdEnd - holdStart;
        }
        // Storing iterative binary search times in binaryTimes[]
        for (int i = 0; i < binaryTimes.length; i++){
            holdStart = System.nanoTime();
            binary.search(arr1, 2500);
            holdEnd = System.nanoTime();
            binaryTimes[i] += holdEnd - holdStart;
        }
        // Storing recursive Binary search times in binaryTimes[]
        for (int i = 0; i < recBinaryTimes.length; i++){
            holdStart = System.nanoTime();
            binaryRec.search(arr1, 2500);
            holdEnd = System.nanoTime();
            recBinaryTimes[i] += holdEnd - holdStart;
        }
        report(linearTimes, recLinearTimes, binaryTimes, recBinaryTimes, 3000, 500);

    }

    /**
     * Generates a random ordered array of integers of the provided size
     *
     * @param size Size of the random array
     * @return An array of the provided size of random numbers in ascending
     * order.
     */
    public static Integer[] generateRandomArray(int size) {
        Random rand = new Random();

        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(2000);
        }

        Arrays.sort(array);
        return array;
    }

    /**
     * Generates the output to both a Comma Separated Values file called
     * "results.csv" and to the screen.
     *
     * @param iterLinTimes Array of average values for the Iterative Linear
     * Search
     * @param recLinTimes Array of average values for the Recursive Linear
     * Search
     * @param iterBinTimes Array of average values for the Iterative Binary
     * Search
     * @param recBinTimes Array of average values for the Recursive Binary
     * Search
     * @param startIncrement Start increment for array sizes
     * @param increment Increment of array sizes.
     */
    private static void report(long[] iterLinTimes, long[] recLinTimes, long[] iterBinTimes, long[] recBinTimes, int startIncrement, int increment) {
        StringBuilder file = new StringBuilder();
        StringBuilder screen = new StringBuilder();

        screen.append(String.format("N    IterLin\tRecLin\tIterBin\tRecBin%s", System.lineSeparator()));
        file.append(String.format("N,IterLin,RecLin,IterBin,RecBin%s", System.lineSeparator()));

        for (int i = 0; i < iterLinTimes.length; i++) {
            screen.append(String.format("%d %d\t%d\t%d\t%d%s", startIncrement + (i * increment), iterLinTimes[i], recLinTimes[i], iterBinTimes[i], recBinTimes[i], System.lineSeparator()
            ));
            file.append(String.format("%d,%d,%d,%d,%d%s", startIncrement + (i * increment), iterLinTimes[i], recLinTimes[i], iterBinTimes[i], recBinTimes[i], System.lineSeparator()
            ));
        }

        System.out.println(screen.toString());

        Path p = Paths.get("results.csv");
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {

        }

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
            pw.println(file.toString());
        } catch (IOException e) {

        }
    }
}
