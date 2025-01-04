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

        int count = 0;
        for (int i=0;i<N;i++) {
            long K = arr[i];
            int start_index = 0;
            int end_index = N - 1;
            while (start_index<end_index) {
                if (arr[start_index] + arr[end_index] > K) {
                    end_index--;
                } else if (arr[start_index] + arr[end_index] < K) {
                    start_index++;
                } else {
                    if (start_index!=i&&end_index!=i) {
                        count++;
                        break;
                    } else if (start_index==i) {
                        start_index++;
                    } else if (end_index==i) {
                        end_index--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
