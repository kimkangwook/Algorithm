package com.Algorithm.doitcoding.sort;

public class 병합정렬BottomUp {

    private static int[] sorted;

    public static void 병합정렬(int[] a) {
        sorted = new int[a.length];
        병합정렬(a, 0, a.length - 1);
        sorted=null;
    }

    private static void 병합정렬(int[] a, int left, int right) {

        for (int size=1; size <= right; size += size) {

            for (int l=0;l<=right-size;l += (2*size)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (2 * size) - 1, right);
                병합(a, low, mid, high);
            }
        }

    }

    private static void 병합(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l<=mid && r<=right) {
            if (a[l]<=a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if (r>right) {
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
