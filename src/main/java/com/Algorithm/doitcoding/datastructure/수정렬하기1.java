package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for (int j = N - 1; j >= 0; j--) {
            boolean isSwap = false;

            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    isSwap = true;
                }
            }
            if (!isSwap) break;
        }

        for (int i=0;i<N;i++) {
            System.out.println(arr[i]);
        }

    }

    private static void swap(int a, int b, int[] arr) {
        int pocket = arr[a];
        arr[a] = arr[b];
        arr[b] = pocket;
    }


}
