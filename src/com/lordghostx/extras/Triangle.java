package com.lordghostx.extras;

import java.time.Instant;

public class Triangle {
    public static void main(String[] args) {
        int limit = 500;
        long now = Instant.now().toEpochMilli();
        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                for (int k = 1; k <= limit; k++) {
                    if ((i * i) + (j * j) == k * k) {
                        System.out.printf("%d\t%d\t%d%n", i, j, k);
                    }
                }
            }
        }
        System.out.println((Instant.now().toEpochMilli() - now) / 1000.0);
    }
}
