package com.Algorithm.doitcoding.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];

        for (int i=0;i<N;i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1]==b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });

        int end = 0;
        int count = 0;

        for (int i=0;i<N;i++) {
            if (end<=A[i][0]) {
                count++;
                end = A[i][1];
            }
        }

        System.out.println(count);



    }
}
