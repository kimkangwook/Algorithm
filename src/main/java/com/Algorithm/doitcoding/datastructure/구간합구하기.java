package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int questionSize = sc.nextInt();
        int[] numbers = new int[size];
        int[] sums = new int[size];

        for (int i=0;i<size;i++) {
            numbers[i] = sc.nextInt();
        }

        sums[0] = numbers[0];

        for (int i=1;i<size;i++) {
            sums[i] = sums[i - 1] + numbers[i];
        }

        for (int i=0;i<questionSize;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (start == 1) {
                System.out.println(sums[end-1]);
            } else {
                System.out.println(sums[end-1]-sums[start-2]);
            }
        }
    }
}
