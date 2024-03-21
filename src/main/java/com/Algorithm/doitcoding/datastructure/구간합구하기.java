package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int size = Integer.parseInt(stringTokenizer.nextToken());
        int questionSize = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[size + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i=1;i<=size;i++) {
            S[i] = S[i-1] +Integer.parseInt(stringTokenizer.nextToken());
        }


        for (int i=0;i<questionSize;i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[end]-S[start-1]);
        }
    }
}
