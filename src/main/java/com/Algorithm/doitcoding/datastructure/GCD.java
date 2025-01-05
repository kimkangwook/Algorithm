package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GCD {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N;
        for (int p = 2;p<=Math.sqrt(N);p++) {
            if (N%p==0) {
                result = result - result / p;
                while (N%p==0) {
                    N /= p;
                }
            }
        }

        if (N>1) {
            result = result - result / N;
        }
        System.out.println(result);
    }
}
