package com.Algorithm.doitcoding.자료구조.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 수정렬하기_2750 {
    public static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        array = new int[N];
        for (int i=0;i<N;i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        for (int i=0;i<N;i++) {
            System.out.println(array[i]);
        }
    }


}
