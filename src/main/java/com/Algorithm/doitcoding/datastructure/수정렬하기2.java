package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2 {

    public static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        sorted = new int[N];
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(arr, 0, N - 1);
        sorted = null;

        // TODO: 시스템 아웃 찍기
        for (int i=0;i<N;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge_sort(int[] a, int start, int end) {
        if (start>=end)
            return;

        int mid = (start + end) / 2;

        merge_sort(a, start, mid);
        merge_sort(a, mid + 1, end);
        merge(a, start, mid, end);
    }



    public static void merge(int[] a, int start, int mid, int end) {
        int l = start;
        int index = start;
        int m = mid + 1;


        while (l<=mid && m<=end) {

            if (a[l] <= a[m]) {
                sorted[index] = a[l];
                index++;
                l++;
            } else {
                sorted[index] = a[m];
                index++;
                m++;
            }
        }

        if (l>mid) {
            while (m<=end) {
                sorted[index] = a[m];
                index++;
                m++;
            }
        } else {
            while (l<=mid) {
                sorted[index] = a[l];
                index++;
                l++;
            }
        }

        for (int i=start;i<=end;i++) {
            a[i] = sorted[i];
        }
    }
}
