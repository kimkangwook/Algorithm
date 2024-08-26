package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내림차순으로자릿수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] arr = new int[chars.length];
        for (int i=0;i<chars.length;i++) {
            arr[i] = chars[i] - '0';
        }

        for (int i=0;i<chars.length-1;i++) {

            int max = 0;
            int index = 0;
            for (int j=i;j<chars.length;j++) {
                if (max<arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }

            if (i==0||index!=0) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }


        }

        for (int i=0; i<arr.length;i++) {
            System.out.print(arr[i]);
        }

    }
}
