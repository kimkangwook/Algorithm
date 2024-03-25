package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 수정렬하기1 {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }


        for (int i=0;i<N-1;i++) {
            boolean breakTF = true;
            for (int j=0;j<N-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j,j+1);
                    breakTF = false;
                }
            }
            if (breakTF)
                break;
        }

        for (int i=0;i<N;i++) {
            System.out.println(arr[i]);
        }

    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
