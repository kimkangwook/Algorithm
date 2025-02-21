package com.Algorithm.doitcoding.자료구조.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합_10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] C = new long[M];
        long sum = 0;
        long count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            long number = Long.parseLong(st.nextToken());
            sum = sum + number;
            int remainder = (int) (sum % M);
            if (remainder==0) {
                count++;
            }
            C[remainder]++;
        }

        for (int i=0;i<M;i++) {
            if (C[i]>1) {
                count = count + (C[i] * (C[i] - 1)) / 2;
            }
        }

        System.out.println(count);
    }
}
