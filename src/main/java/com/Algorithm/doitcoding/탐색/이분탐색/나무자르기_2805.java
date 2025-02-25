package com.Algorithm.doitcoding.탐색.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] trees = new long[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            trees[i] = Long.parseLong(st.nextToken());
            if (max<trees[i]) {
                max = trees[i];
            }
        }

        System.out.println(upperBound(max, trees, M));



    }

    public static long upperBound(long max, long[] trees, long number) {
        long lo = 0;
        long high = max + 1;

        while (lo<high) {
            long mid = (lo + high) / 2;
            long sum = 0;

            for (int i=0;i<trees.length;i++) {
                if (trees[i]>number)
                    sum += (trees[i] % mid);
            }

            if (number<=sum) {
                lo = mid + 1;
            } else {
                high = mid;
            }
        }

        return lo - 1;
    }
}
