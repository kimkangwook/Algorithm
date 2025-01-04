package com.Algorithm.doitcoding.sort;

public class 병합정렬BottomUp {

    private static int[] sorted;

    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right) {

        for (int size=1;size<=right;size+=size) {


            for (int i=0;i<=right-size;i+=2 * size) {
                int l = i;
                int mid = i + size - 1;
                int r = Math.min(i + (2 * size) - 1, right);
                merge_sort(a,l,mid,r);
            }

        }
    }

    private static void merge_sort(int[] a, int left, int mid, int right) {

        int idx = left;
        int l = left;
        int r = mid + 1;

        while (l<=mid&&r<=right) {

            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if (l<mid) {
            while (l<=mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        } else {
            while (r<=right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        for (int i=left;i<=right;i++) {
            a[i] = sorted[i];
        }
    }
}
