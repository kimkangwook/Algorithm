package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최대공약수 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = sc.nextLong();
        long b = sc.nextLong();

        long N = gcd(a, b);

        while (N>0) {
            bw.write("1");
            N--;
        }
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {
        if (a%b==0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
