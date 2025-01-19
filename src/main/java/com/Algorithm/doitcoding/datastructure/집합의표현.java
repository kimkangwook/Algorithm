package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 집합의표현 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for (int i=1;i<=N;i++) {
            arr[i] = i;
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a==0) {
                union(b, c);
            } else {
                boolean isFind = find(b, c);
                if (isFind) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int b, int c) {
        while (b!=arr[b]) {
            b = arr[b];
        }
        while (c!=arr[c]) {
            c = arr[c];
        }
        int min = Math.min(b, c);
        arr[b] = min;
        arr[c] = min;
    }

    public static boolean find(int b, int c) {
        ArrayList<Integer> array = new ArrayList<>();
        while (b!=arr[b]) {
            array.add(b);
            b = arr[b];
        }
        for (int n: array) {
            arr[n] = b;
        }
        array = new ArrayList<>();

        while (c!=arr[c]) {
            c = arr[c];
        }
        for (int n: array) {
            arr[n] = c;
        }

        if (b==c) {
            return true;
        } else {
            return false;
        }
    }
}
