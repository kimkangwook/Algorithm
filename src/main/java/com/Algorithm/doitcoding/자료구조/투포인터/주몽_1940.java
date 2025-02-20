package com.Algorithm.doitcoding.자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int start_index = 0;
        int end_index = N - 1;
        int count = 0;
        while (start_index<end_index) {
            if (array[start_index] + array[end_index] == M) {
                count++;
                start_index++;
                end_index--;
            } else if (array[start_index] + array[end_index] > M) {
                end_index--;
            } else {
                start_index++;
            }
        }
        System.out.println(count);

    }
}
