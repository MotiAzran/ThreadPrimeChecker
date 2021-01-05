package com.moti;

/**
 * Thread that check if number is prime
 */
public class PrimeCheck implements Runnable {
    int _num;
    PrimeListMonitor _primeList;

    /**
     * Initialize prime check thread
     * @param num number to check
     * @param primeList list to add the number if it prime
     */
    public PrimeCheck(int num, PrimeListMonitor primeList) {
        _num = num;
        _primeList = primeList;
    }

    /**
     * Checks if the number is prime
     * if it is so add it to the prime list
     */
    @Override
    public void run() {
        if (_num < 2) {
            // number less then 2 is not prime
            return;
        }

        // Check if the number has divisor
        for (int i = 2; i <= Math.sqrt(_num); ++i) {
            if (_num % i == 0) {
                return;
            }
        }

        // The number is prime
        _primeList.setToPrime(_num);
    }
}
