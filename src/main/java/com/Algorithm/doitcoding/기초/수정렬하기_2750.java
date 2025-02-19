package com.Algorithm.doitcoding.기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] array = new boolean[2001];

        int N = Integer.parseInt(br.readLine());

        for (int i=0;i<N;i++) {
            array[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for (int i=0;i<array.length;i++) {
            if (array[i]) {
                sb.append(i-1000).append("\n");
            }
        }
        System.out.println(sb);
    }
}
