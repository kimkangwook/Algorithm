package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 연속된자연수의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;
        int start_index = 1;
        int end_index = 1;

        while (start_index<=N&&end_index<=N) {
            if (sum>N) {
                sum -= start_index;
                start_index++;
            } else if (sum<N) {
                end_index++;
                sum += end_index;
            } else {
                if (start_index==end_index) {
                    break;
                }
                count++;
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);


    }
}
