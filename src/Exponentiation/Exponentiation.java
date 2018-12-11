package Exponentiation;

import java.math.BigInteger;

public class Exponentiation {

    private static long linearExponentiation(long x, int n) {
        if (n < 0) {
            return -1;
        }
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= x;
        }
        return res;
    }

    private static long binExponentiation (long x, int n) {
        if (n < 0) {
            return -1;
        }
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    private static long recursiveExponentiation(long x, int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0)
            return 1;
        if ((n & 1) != 0) {
            return recursiveExponentiation(x, n - 1) * x;
        } else {
            return recursiveExponentiation(x, n >> 1) * recursiveExponentiation(x, n >> 1);
        }
    }

    public static void main(String[] args){
        BigInteger bigInteger = new BigInteger(String.valueOf(10));
        bigInteger.pow(15);
        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = linearExponentiation(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " линейно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2 = linearExponentiation(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " линейно за " + (finish2 - start2) + " наносек");
        }).start();

        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = binExponentiation(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " бинарно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2 = binExponentiation(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " бинарно за " + (finish2 - start2) + " наносек");
        }).start();

        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = recursiveExponentiation(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " рекурсивно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2= recursiveExponentiation(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " рекурсивно за " + (finish2 - start2) + " наносек");
        }).start();
    }
}
