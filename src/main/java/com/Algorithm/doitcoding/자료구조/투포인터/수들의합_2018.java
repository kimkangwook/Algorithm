package com.Algorithm.doitcoding.자료구조.투포인터;

import java.util.Scanner;

public class 수들의합_2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start_index = 1;
        int end_index = 1;
        long sum = 1;
        long count = 1;

        while (end_index<N) {
            if (sum==N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum>N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);
    }
}
