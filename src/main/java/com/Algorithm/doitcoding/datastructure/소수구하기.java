package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 소수구하기 {

    public static void main(String[] args) {

        boolean[] bool = new boolean[1000001];

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        bool[1] = true;

        for (int i=2;i<=N;i++) {
            int count = 2;
            while (true) {
                if (count*i>N) {
                    break;
                } else {
                    bool[count * i] = true;
                    count++;
                }
            }
        }

        for (int i=M;i<=N;i++) {
            if (!bool[i]) {
                System.out.println(i);
            }
        }

    }
}
