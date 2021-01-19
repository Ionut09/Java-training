package concurrency;

import java.util.List;
import java.util.stream.LongStream;

import static java.lang.System.currentTimeMillis;

public class Primes {

    public static void main(String... args) {
        long start = currentTimeMillis();
        var count = LongStream.range(3, 5_000_000)
                                  .parallel()
                                  .filter(Primes::isPrime)
                                  .count();
        System.out.format("Execution took: %.2f seconds and found %d primes",
                (currentTimeMillis() - start) / 1000.0, count);
    }

    private static boolean isPrime(long num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
