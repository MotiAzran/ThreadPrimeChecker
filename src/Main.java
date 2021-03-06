/*
 * Moti Azran
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the program
 */
public class Main {
    /**
     * program entry point
     * print all the prime number
     * until some number
     * @param args command line arguments
     *             seriesMaxNumber - The number to stop prime check at
     *             numberOfThreads - Max number of threads to run in parallel
     */
    public static void main(String[] args) {
        final int SERIES_MAX_NUMBER_INDEX = 0;
        final int MAX_NUM_OF_THREAD_INDEX = 1;
        final int ARGS_COUNT = 2;

        if (args.length != ARGS_COUNT) {
            System.out.println("Error: Invalid parameters");
            System.out.println("usage: PrimeChecker <MaxSeriesNumber> <NumOfThreads>");
            return;
        }

        int seriesMax = 0;
	    int maxNumOfThreads = 0;

        try {
	        seriesMax = Integer.parseInt(args[SERIES_MAX_NUMBER_INDEX]);
	        maxNumOfThreads = Integer.parseInt(args[MAX_NUM_OF_THREAD_INDEX]);
    	} catch(NumberFormatException e) {
    		System.out.println("Error: parameters should be integers");
            return;
    	}

        printPrimeSeries(seriesMax, maxNumOfThreads);
    }

    /**
     * Print all primes until series max
     * @param seriesMax the max number to check
     * @param maxNumOfThreads max number of threads to run in parallel
     */
    public static void printPrimeSeries(int seriesMax, int maxNumOfThreads) {
        final int THREADS_TIMEOUT_MIN = 5;

        PrimeListMonitor primeList = new PrimeListMonitor();
        ExecutorService threadPool = Executors.newFixedThreadPool(maxNumOfThreads);

        System.out.println("Checking...");
        // Run prime check threads
        for (int i = 0; i < seriesMax; ++i) {
            threadPool.execute(new PrimeCheck(primeList));
        }

        // Close thread pool
        threadPool.shutdown();

        try {
            // Wait for all threads to finish their work
            threadPool.awaitTermination(THREADS_TIMEOUT_MIN, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print all primes
        primeList.printPrimes();
    }
}
