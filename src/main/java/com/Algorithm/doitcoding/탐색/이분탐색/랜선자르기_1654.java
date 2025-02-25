package com.Algorithm.doitcoding.탐색.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sticks = new long[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            sticks[i] = Long.parseLong(st.nextToken());
            if (max<sticks[i])
                max = sticks[i];
        }

        System.out.println(upperBound(max, sticks, M));

    }

    public static long upperBound(long max, long[] sticks, int number) {
        long low = 0;
        long high = max + 1;

        while (low<high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i=0;i<sticks.length;i++) {
                if (sticks[i]>mid)
                sum += (sticks[i] - mid);
            }

            if (number<=sum) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low-1;
    }
}
