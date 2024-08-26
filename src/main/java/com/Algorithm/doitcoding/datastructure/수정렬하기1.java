package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기1 {
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] unsorted = new int[N];
        for (int i=0;i<N;i++) {
            unsorted[i] = Integer.parseInt(br.readLine());
        }

        // 병합정렬 TopDown
        병합정렬(unsorted);

        for (int i=0;i<N;i++) {
            System.out.println(unsorted[i]);
        }

        sorted = null;
    }

    public static void 병합정렬(int[] unsorted) {
        sorted = new int[unsorted.length];
        병합정렬(unsorted, 0, unsorted.length - 1);
    }

    public static void 병합정렬(int[] unsorted, int left, int right) {

        if (left==right) return;

        int mid = (left + right) / 2;

        병합정렬(unsorted, left, mid);
        병합정렬(unsorted, mid + 1, right);
        병합(unsorted, left, mid, right);
    }

    public static void 병합(int[] unsorted, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l<=mid && r<=right) {
            if (unsorted[l]<=unsorted[r]) {
                sorted[idx] = unsorted[l];
                idx++;
                l++;
            } else {
                sorted[idx] = unsorted[r];
                idx++;
                r++;
            }
        }

        if (l<=mid) {
            while (l<=mid) {
                sorted[idx] = unsorted[l];
                idx++;
                l++;
            }
        } else {
            while (r<=right) {
                sorted[idx] = unsorted[r];
                idx++;
                r++;
            }
        }

        for (int i=left;i<=right;i++) {
            unsorted[i] = sorted[i];
        }
    }


}
