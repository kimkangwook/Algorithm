package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int count=0;

        for (int i=0;i<N;i++) {
            int startIndex=0;
            int endIndex=N-1;

            while (startIndex<endIndex) {
                if (arr[i]>arr[startIndex]+arr[endIndex]) {
                    startIndex++;
                } else if (arr[i]<arr[startIndex]+arr[endIndex]) {
                    endIndex--;
                } else if (arr[i]==arr[startIndex]+arr[endIndex]) {
                    if (i==startIndex) {
                       startIndex++;
                    } else if (i==endIndex) {
                        endIndex--;
                    } else {
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
