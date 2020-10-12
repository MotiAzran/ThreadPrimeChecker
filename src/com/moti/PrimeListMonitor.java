package com.moti;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeListMonitor {
    private boolean[] _is_prime;

    public PrimeListMonitor(int list_max) {
        _is_prime = new boolean[list_max];
    }

    public synchronized void set_to_prime(int num) {
        _is_prime[num-1] = true;
    }

    public synchronized void print_primes() {
        for (int i = 0; i < _is_prime.length; ++i) {
            if (_is_prime[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
