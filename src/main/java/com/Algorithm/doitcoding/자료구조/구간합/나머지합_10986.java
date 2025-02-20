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

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[N + 1];
        long[] C = new long[M];
        long answer = 0;

        for (int i=1;i<=N;i++) {
            long number = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + number;
        }

        for (int i=1;i<=N;i++) {
            int remainder = (int)(sum[i] % M);
            if (remainder==0) {
                answer++;
            }
            C[remainder]++;
        }

        for (int i=0;i<M;i++) {
            if (C[i]>1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);

    }
}
