package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
        System.out.println(sb);
    }

    public static void DFS(int a, int n) {

        if (n==N) {
            if (isDecimal(a)) {
                sb.append(a).append("\n");
            }
            return;
        }

        if (isDecimal(a)) {
            for (int i=1;i<10;i+=2) {
                int next = 10 * a +i;
                DFS(next,n+1);
            }
        }
    }

    public static boolean isDecimal(int a) {

        for (int i=2;i<=a/2;i++) {
            if (a%i==0) return false;
        }

        return true;
    }
}
