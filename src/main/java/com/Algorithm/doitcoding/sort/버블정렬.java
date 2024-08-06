package com.Algorithm.doitcoding.sort;

public class 버블정렬 {

    public static void 버블정렬(int[] a) {
        버블정렬(a, a.length);
    }

    private static void 버블정렬(int[] a, int size) {

        // round는 배열 크기 - 1 횟수
        for (int i=1;i<size;i++) {

             boolean swapped = false;
            // 비교해서 순서바꾸기
            for (int j=0;j<size-i;j++) {

                // 현재 원소가 다음 원소보다 클 경우 서로의 원소 위치 교환
                if (a[j] > a[j+1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }

                //   swap된적이 없다면 이미 정렬되었다는 의미
                if (!swapped) {
                    break;
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
