package com.Algorithm.doitcoding.탐색.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lines = new long[K];
        long max = 0;
        for (int i=0;i<K;i++) {
            lines[i] = Long.parseLong(br.readLine());
            if (max<lines[i])
                max = lines[i];
        }

        System.out.println(upperBound(lines,max,N));
    }

    public static long upperBound(long[] lines, long max, long N) {
        long low = 0;
        long high = max + 1;

        while (low<high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (long length: lines) {
                sum += (length / mid);
            }

            if (N<=sum) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }
}
