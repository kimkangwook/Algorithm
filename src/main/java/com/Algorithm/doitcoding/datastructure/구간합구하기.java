package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            S[i] = S[i-1] + Long.parseLong(st.nextToken());
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            System.out.println(S[endIndex] - S[startIndex-1]);
        }

    }
}
