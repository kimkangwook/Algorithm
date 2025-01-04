package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] bool = new boolean[N + 1];
        bool[1] = true;

        for (int i=2;i<=N;i++) {
            int count = 2;
            while (count*i<=N) {
                bool[count * i] = true;
                count++;
            }
        }

        for (int i=M;i<=N;i++) {
            if (!bool[i]) {
                System.out.println(i);
            }
        }


    }
}
