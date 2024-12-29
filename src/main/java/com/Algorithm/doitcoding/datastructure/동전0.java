package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 동전0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for (int i=N-1;i>=0;i--) {
            int n = A[i];
            if (n<=K) {
                count += K / n;
                K = K % n;
            } else {
                continue;
            }

            if (K==0) {
                break;
            }
        }
        System.out.println(count);
    }
}
