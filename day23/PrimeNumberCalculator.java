package day23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PrimeCalculator implements Runnable {
    private final int start;
    private final int end;
    private final List<Integer> primes;

    public PrimeCalculator(int start, int end, List<Integer> primes) {
        this.start = start;
        this.end = end;
        this.primes = primes;
    }

    @Override
    public void run() {
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                synchronized (primes) {
                    primes.add(num);
                }
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class PrimeNumberCalculator {
    private static final int MAX_NUMBER = 10000;

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        int range = 1000;

        for (int i = 1; i <= MAX_NUMBER; i += range) {
            executor.submit(new PrimeCalculator(i, i + range - 1, primes));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        CompletableFuture.runAsync(() -> writePrimesToFile(primes)).join();
        System.out.println("Prime numbers calculation and writing to file completed.");
    }

    private static void writePrimesToFile(List<Integer> primes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            for (int prime : primes) {
                writer.write(prime + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}