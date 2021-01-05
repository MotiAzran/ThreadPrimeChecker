import java.util.ArrayList;

/**
 * Holds boolean that says
 * if (index+1) is prime or not
 */
public class PrimeListMonitor {
    private int currentNumber;
    private ArrayList<Integer> primes;

    /**
     * Initialize monitor
     */
    public PrimeListMonitor() {
        primes = new ArrayList<Integer>();
        currentNumber = 1;
    }

    public synchronized int getNumber() {
        return currentNumber++;
    }

    /**
     * Set number to prime in the monitor
     * @param num number to set as prime in the list
     */
    public synchronized void setToPrime(int num) {
        primes.add(num);
    }

    /**
     * Print all primes numbers
     */
    public synchronized void printPrimes() {
        for (int prime : primes) {
            System.out.println(prime);
        }
    }
}
