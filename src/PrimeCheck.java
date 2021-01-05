/**
 * Thread that check if number is prime
 */
public class PrimeCheck implements Runnable {
    PrimeListMonitor primeList;

    /**
     * Initialize prime check thread
     * @param primeList list to add the number if it prime
     */
    public PrimeCheck(PrimeListMonitor primeList) {
        this.primeList = primeList;
    }

    /**
     * Checks if the number is prime
     * if it is so add it to the prime list
     */
    @Override
    public void run() {
        int num = primeList.getNumber();

        if (num < 2) {
            // number less then 2 is not prime
            return;
        }

        // Check if the number has divisor
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return;
            }
        }

        // The number is prime
        primeList.setToPrime(num);
    }
}
