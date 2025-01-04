package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM인출시간계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1;i<N;i++) {
            int insert_point = i;
            int insert_value = arr[i];

            for (int j=i-1;j>=0;j--) {
                if (arr[j] < arr[i]) {
                    insert_point = j + 1;
                    break;
                }
                if (j==0) {
                    insert_point = 0;
                }
            }

            for (int j=i-1;j>=insert_point;j--) {
                arr[j + 1] = arr[j];
            }
            arr[insert_point] = insert_value;
        }

        sum[0] = arr[0];
        for (int i=1;i<arr.length;i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int S = 0;

        for (int i=0;i<sum.length;i++) {
            S += sum[i];
        }
        System.out.println(S);




    }
}
