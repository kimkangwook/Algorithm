package com.Algorithm.doitcoding.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[N+1];
        for (int i=1;i<=N;i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i==1) {
                sum[i] = number;
            } else {
                sum[i] = sum[i - 1] + number;
            }
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum[end]-sum[start-1]).append('\n');
        }
        System.out.println(sb);
    }
}
