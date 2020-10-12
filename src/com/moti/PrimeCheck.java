package com.moti;

public class PrimeCheck implements Runnable {

    int _num;
    PrimeListMonitor _prime_list;

    public PrimeCheck(int num, PrimeListMonitor prime_list) {
        _num = num;
        _prime_list = prime_list;
    }

    @Override
    public void run() {
        if (_num <= 1) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(_num); ++i) {
            if (_num % i == 0) {
                return;
            }
        }

        _prime_list.set_to_prime(_num);
    }
}
