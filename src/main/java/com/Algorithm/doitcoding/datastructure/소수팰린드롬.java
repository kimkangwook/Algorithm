package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 소수팰린드롬 {

    public static int number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] A = new boolean[10000001];
        A[1] = true;

        for (int i=2;i<Math.sqrt(10000001);i++) {
            if (A[i]) {
                continue;
            }

            for (int j=i+i;j<10000001;j=j+i) {
                A[j] =true;
            }
        }


        for (int i=N;i<10000001;i++) {
            if (!A[i]) {
                char[] chars = String.valueOf(i).toCharArray();
                if (isPalindrom(chars)) {
                    break;
                }
            }
        }
        System.out.println(number);
    }

    public static boolean isPalindrom(char[] chars) {
        int S = 0;
        int E = chars.length - 1;
        boolean answer = true;
        for (int i=0;i<chars.length/2;i++) {
            if (chars[S+i]!=chars[E-i]) {
                answer = false;
            }
        }
        number = Integer.parseInt(String.valueOf(chars));
        return answer;
    }
}
