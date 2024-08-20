package com.Algorithm.doitcoding.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        float max = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max<arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
        }

        System.out.println((sum/max)/N * 100);

    }
}
