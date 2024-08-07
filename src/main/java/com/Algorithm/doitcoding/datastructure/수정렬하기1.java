package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 수정렬하기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        int[] arr = new int[i];

        for (int j=0;j<i;j++) {
            arr[j] = Integer.parseInt(br.readLine());
        }

        // 버블 정렬
        // 라운드 수는 배열의 size-1
        for (int k=1;k<i;k++) {

            for (int l=0;l<i-k;l++) {
                if (arr[l]>arr[l+1]) {
                    int temp = arr[l];
                    arr[l] = arr[l+1];
                    arr[l+1] = temp;
                }

            }

        }

        for (int m=0;m<i;m++) {
            System.out.println(arr[m]);
        }


    }


}
