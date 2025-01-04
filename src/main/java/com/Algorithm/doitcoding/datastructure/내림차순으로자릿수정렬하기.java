package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 내림차순으로자릿수정렬하기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];
        for (int i=0;i<str.length();i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i=0;i<arr.length;i++) {
            int max = i;
            for (int j=i;j<arr.length;j++) {
                if (arr[j]>arr[max]) {
                    max = j;
                }
            }
            if (arr[max]>arr[i]) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
        }
    }
}
