package com.Algorithm.doitcoding.sort;

public class 병합정렬TopDown {

    private static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시 배열

    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted  = null;
    }

    private static void merge_sort(int[] a, int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;  // 절반 위치

        merge_sort(a,left,mid); // 절반 중 왼쪽 부분리스트(left ~ mid)
        merge_sort(a, mid + 1, right); // 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge(a, left, mid, right); // 병합 작업
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left; // 왼쪽 부분리스트 시작점
        int r = mid + 1; // 오른쪽 부분리스트 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while (l<=mid && r<=right) {
            /*
             * 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             * 왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킴
             */
            if (a[l]<=a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            /*
             * 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작을 경우
             * 오른쪽 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킴
             */
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워줌 (반대로도 마찬가지)
         */
        if (l > mid) {
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

        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨줌
         */
        for (int i=left;i<=right;i++) {
            a[i] = sorted[i];
        }
    }

}
