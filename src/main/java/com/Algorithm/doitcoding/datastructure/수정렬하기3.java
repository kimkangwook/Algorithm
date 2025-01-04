package com.Algorithm.doitcoding.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int max = 0;
        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (max < array[i]) max = array[i];
        }

        radixSort(array, max);

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++) {
            sb.append(array[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void radixSort(int[] array, int max) {
        int n = array.length;
        int[] count = new int[10];
        int[] output = new int[n];
        int digit = 1;

        while (max/digit>0) {

            // 카운트 배열 정리
            for (int i=0;i<10;i++) {
                count[i] = 0;
            }

            // 기존 배열 돌면서 카운트 배열 채우기
            for (int i=0;i<n;i++) {
                int index = (array[i] / digit) % 10;
                count[index]++;
            }

            // 카운트 배열 누적합으로 위치 정하기
            for (int i=1;i<10;i++) {
                count[i] += count[i - 1];
            }

            // output 배열에 순서대로 담기
            // 누적합이기 때문에 각 자릿수의 큐에서 맨뒤부터 차례로 담아줌
            for (int i=n-1;i>=0;i--) {
                int index = (array[i] / digit) % 10;
                output[--count[index]] =array[i];
            }

            // 원본 배열에 옮겨주기
            System.arraycopy(output, 0, array, 0, n);

            // 자릿수 올리기
            digit *= 10;
        }
    }
}
