package com.Algorithm.doitcoding.sort;

public class 병합정렬TopDown {

    private static int[] sorted;

    public static void 병합정렬(int[] a) {
        sorted = new int[a.length];
        병합정렬(a, 0, a.length - 1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void 병합정렬(int[] a, int left, int right) {

        // left==right는 부분리스트가 1개의 원소만 갖는 경우
        if (left==right) return;

        int mid = (left + right) / 2; // 절반 위치

        병합정렬(a, left, mid);
        병합정렬(a, mid + 1, right);

        병합(a, left, mid, right);
    }

    private static void 병합(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid+1;
        int idx = left;

        while (l<=mid && r<=right) {
            if (l<=right) {
                sorted[idx] = a[l];
                l++;
                idx++;
            } else {
                sorted[idx] = a[r];
                r++;
                idx++;
            }
        }

        if (l>mid) {
            while (r<=right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            while (l<=mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for (int i=left;i<=right;i++) {
            a[i] = sorted[i];
        }
    }
}
