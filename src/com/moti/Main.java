package com.moti;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        final int SERIES_MAX_NUMBER_INDEX = 0;
        final int MAX_NUM_OF_THREAD_INDEX = 1;
        final int ARGS_COUNT = 2;

        if (args.length != ARGS_COUNT) {
            System.out.println("Error: Invalid parameters");
            System.out.println("usage: PrimeChecker <MaxSeriesNumber> <NumOfThreads>");
            return;
        } else if (!args[SERIES_MAX_NUMBER_INDEX].chars().allMatch(Character::isDigit) ||
                   !args[SERIES_MAX_NUMBER_INDEX].chars().allMatch(Character::isDigit)) {
            System.out.println("Error: parameters should be integers");
            return;
        }

        int series_max = Integer.parseInt(args[SERIES_MAX_NUMBER_INDEX]);
        int max_num_of_threads = Integer.parseInt(args[MAX_NUM_OF_THREAD_INDEX]);

        print_prime_series(series_max, max_num_of_threads);
    }

    public static void print_prime_series(int series_max, int max_num_of_threads) {
        PrimeListMonitor prime_list = new PrimeListMonitor(series_max);
        ExecutorService thread_pool = Executors.newFixedThreadPool(max_num_of_threads);

        System.out.println("Checking...");
        for (int i = 1; i <= series_max; ++i) {
            thread_pool.execute(new PrimeCheck(i, prime_list));
        }

        thread_pool.shutdown();

        try {
            thread_pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        prime_list.print_primes();
    }
}
