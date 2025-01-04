package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 소수팰린드롬 {

    public static int number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[10000001];

        for (int i=2;i<A.length;i++) {
            A[i] = i;
        }

        for (int i=2;i<Math.sqrt(A.length);i++) {
            if (A[i]==0) {
                continue;
            }
            for (int j=i+i;j<A.length;j=j+i) {
                A[j] = 0;
            }
        }

        for (int i=N;i<A.length;i++) {
            if (A[i]!=0) {
                char[] chars = String.valueOf(A[i]).toCharArray();
                if (isPalindrom(chars)) break;
            }
        }

        System.out.println(number);
    }

    public static boolean isPalindrom(char[] chars) {
        int S = 0;
        int E = chars.length-1;
        boolean palindrom = true;
        for (int i=0;i<chars.length/2;i++) {
            if (chars[S+i]!=chars[E-i]) {
                palindrom = false;
                break;
            }
        }
        if (palindrom) {
            number = Integer.parseInt(String.valueOf(chars));
        }
        return palindrom;
    }
}
