package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start_index = 0;
        int end_index = N - 1;
        int count = 0;

        while (start_index!=end_index && start_index<end_index) {
            if (arr[start_index] + arr[end_index] > M) {
                end_index--;
            } else if (arr[start_index] + arr[end_index] < M) {
                start_index++;
            } else {
                count++;
                start_index++;
                end_index--;
            }
        }

        System.out.println(count);
    }
}
