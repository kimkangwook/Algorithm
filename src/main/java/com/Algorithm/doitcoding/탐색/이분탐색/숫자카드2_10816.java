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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(upperBound(array,number) - lowerBound(array,number)).append(' ');
        }
        System.out.println(sb);

    }


    public static int lowerBound(int[] array, int number) {
        int low = 0;
        int high = array.length;

        while (low<high) {
            int mid = (low + high) / 2;

            if (number<=array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int upperBound(int[] array, int number) {
        int low = 0;
        int high = array.length;

        while (low<high) {
            int mid = (low + high) / 2;

            if (number<array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
