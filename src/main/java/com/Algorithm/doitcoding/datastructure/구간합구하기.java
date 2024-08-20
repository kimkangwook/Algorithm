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

        StringBuffer sb = new StringBuffer();

        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            if (i==0) {
                sum[i] = Integer.parseInt(st.nextToken());
            } else {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int startIndex, endIndex;

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            startIndex = Integer.parseInt(st.nextToken())-1;
            endIndex = Integer.parseInt(st.nextToken())-1;

            sb.append(startIndex==0 ? (sum[endIndex]) : sum[endIndex] - sum[startIndex - 1]).append('\n');
        }
        System.out.println(sb);

    }
}
