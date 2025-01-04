package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트 {

    private static int[] sorted;

    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sorted = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);

        //  버블 소트 반환하기
        System.out.println(answer);

        sorted = null;

    }

    public static void merge_sort(int[] a, int start, int end) {

        if (start>=end) return;

        int mid = (start + end) / 2;

        merge_sort(a, start, mid);
        merge_sort(a, mid+1,end);
        merge_sort(a, start, mid, end);
    }

    public static void merge_sort(int[] a, int start, int mid, int end) {
        int idx = start;
        int l = start;
        int r = mid+1;

        while (l<=mid && r<=end) {
            if (a[l] > a[r]) {
                if (idx<r) {
                    answer += r-idx;
                }
                sorted[idx] = a[r];
                idx++;
                r++;
            } else {
                if (idx<l) {
                    answer += l-idx;
                }
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        if (l>mid) {
            while (r<=end) {
                if (idx<r) {
                    answer += r-idx;
                }
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            while (l<=mid) {
                if (idx<l) {
                    answer += l-idx;
                }
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for (int i=start;i<=end;i++) {
            a[i] = sorted[i];
        }
    }
}
