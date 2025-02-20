package com.Algorithm.doitcoding.자료구조.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N + 1];

        for (int i=1;i<=N;i++) {
            int number = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + number;
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            sb.append(sum[endIndex] - sum[startIndex - 1]).append('\n');
        }

        System.out.println(sb);

    }
}
