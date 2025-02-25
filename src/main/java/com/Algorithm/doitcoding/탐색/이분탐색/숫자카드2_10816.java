package com.Algorithm.doitcoding.탐색.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] allArray = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            allArray[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(allArray);

        int M = Integer.parseInt(br.readLine());
        long[] compareArray = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            compareArray[i] = Long.parseLong(st.nextToken());
        }

        for (int i=0;i<M;i++) {
            long number = compareArray[i];
            sb.append(upperBound(allArray, number)-lowerBound(allArray,number)).append(' ');
        }
        System.out.println(sb);

    }

    public static int lowerBound(long[] allArray, long number) {
        int low = 0;
        int high = allArray.length;

        while (low<high) {
            int mid = (low + high) / 2;

            // 하한 -> 같을 시 상한선을 내려야한다
            if (number<=allArray[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(long[] allArray, long number) {
        int low = 0;
        int high = allArray.length;

        while (low<high) {
            int mid = (low + high) / 2;

            // 상한
            if (number<allArray[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
