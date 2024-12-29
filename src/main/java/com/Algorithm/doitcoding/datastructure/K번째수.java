package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class K번째수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int start = 1;
        int end = M;
        int ans = 0;

        while (start<=end) {
            int middle = (start + end) / 2;
            int sum = 0;
            for (int i=1;i<=N;i++) {
                sum += Math.min(middle / i, N);
            }

            if (sum < M) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }

        System.out.println(ans);
    }

}
