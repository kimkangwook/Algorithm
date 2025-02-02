package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 집합의표현 {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n + 1];
        for (int i=1;i<=n;i++) {
            arr[i] = i;
        }

        for (int i=0;i<m;i++) {
            int check = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (check==1) {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(a, b);
            }
        }
    }

    public static int find(int a) {
        if (a==arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        arr[b] = arr[a];
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a==b) {
            return true;
        }
        return false;
    }




}
