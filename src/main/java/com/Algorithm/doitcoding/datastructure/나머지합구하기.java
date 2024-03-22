package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] numbers = new long[N + 1];
        long[] C = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());

        for (int i=1;i<=N;i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++) {
            int remainder = (int) (numbers[i + 1] % M);

            if (remainder == 0) {
                answer++;
            }

            C[remainder]++;
        }

        for (int i=0;i<M;i++) {
            if (C[i] > 1) {
                answer = answer + C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(answer);

    }
}
