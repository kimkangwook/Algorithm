package com.Algorithm.doitcoding.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int max = 0;

        // 입력받으며 최대값 계산
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (array[i] > max) max = array[i];
        }

        // 기수 정렬 실행
        radixSort(array, max);

        // 정렬된 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }

    private static void radixSort(int[] array, int max) {
        int n = array.length;
        int[] output = new int[n]; // 정렬 결과를 임시로 저장할 배열
        int digit = 1;            // 현재 처리할 자릿수 (1, 10, 100, ...)
        int[] count = new int[10]; // 자릿수별 카운트 배열

        // 최대 자릿수까지 반복
        while (max / digit > 0) {
            // 카운트 배열 초기화
            for (int i = 0; i < 10; i++) count[i] = 0;

            // 자릿수별 등장 횟수 계산
            for (int i = 0; i < n; i++) {
                int index = (array[i] / digit) % 10;
                count[index]++;
            }

            // 누적 합으로 위치 계산
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 결과를 임시 배열에 저장
            for (int i = n - 1; i >= 0; i--) {
                int index = (array[i] / digit) % 10;
                output[--count[index]] = array[i];
            }

            // 정렬된 결과를 원본 배열에 복사
            System.arraycopy(output, 0, array, 0, n);

            // 다음 자릿수로 이동
            digit *= 10;
        }
    }
}
