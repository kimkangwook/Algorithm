package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 여행가자 {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n + 1];

        for (int i=1;i<=n;i++) {
            arr[i] = i;
        }

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                int a = sc.nextInt();
                if (a==1) {
                    union(i, j);
                }
            }
        }

        boolean answer = true;
        int a=0;

        for (int i=0;i<m;i++) {
            int city = sc.nextInt();
            if (i==0) {
                a = find(city);
            } else {
                if (a!=find(city)) {
                    answer = false;
                    System.out.println("NO");
                    break;
                }
            }
        }

        if (answer) {
            System.out.println("YES");
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
