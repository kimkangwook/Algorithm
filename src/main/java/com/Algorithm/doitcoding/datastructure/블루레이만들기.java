package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 블루레이만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int max = 0;
        int sum = 0;
        for (int i=0;i<N;i++) {
            A[i] = sc.nextInt();
            sum += A[i];
            if (A[i] > max) max = A[i];
        }
        int start = max;
        int end = sum;
        int ans = 0;


        while (start<=end) {
            int middle = (start + end) / 2;
            int count = 0;
            sum = 0;

            for (int i=0;i<N;i++) {
                sum += A[i];

                if (sum>middle) {
                    count++;
                    sum = A[i];
                } else if (sum==middle) {
                    count++;
                    sum=0;
                }
            }
            if (sum!=0) {
                count++;
            }

            if (count>M) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }

        System.out.println(ans);


    }

}
