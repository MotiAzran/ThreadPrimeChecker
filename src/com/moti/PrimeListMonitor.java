package com.moti;

/**
 * Holds boolean that says
 * if (index+1) is prime or not
 */
public class PrimeListMonitor {
    private boolean[] _isPrime;

    /**
     * Initialize monitor
     * @param list_max max number of the list
     */
    public PrimeListMonitor(int list_max) {
        _isPrime = new boolean[list_max];
    }

    /**
     * Set number to prime in the monitor
     * @param num number to set as prime in the list
     */
    public synchronized void setToPrime(int num) {
        if (num <= 0 || num > _isPrime.length) {
            return;
        }

        _isPrime[num-1] = true;
    }

    /**
     * Print all primes numbers
     */
    public synchronized void printPrimes() {
        for (int i = 0; i < _isPrime.length; ++i) {
            if (_isPrime[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
