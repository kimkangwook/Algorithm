package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수찾기 {

    static int[] A;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        for (int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i=0;i<M;i++) {
            int number = sc.nextInt();
            binarySearch(number);
        }
        System.out.println(sb);
    }

    public static void binarySearch(int number) {
        int start = 0;
        int end = A.length-1;

        while (start<=end) {
            int middle = (start + end) / 2;

            if (A[middle] > number) {
                end = middle - 1;
            } else if (A[middle] < number) {
                start = middle + 1;
            } else {
                sb.append(1).append('\n');
                return;
            }
        }
        sb.append(0).append('\n');
    }

}
