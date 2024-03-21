package com.Algorithm.doitcoding.test;

public class Test {
    public static void main(String[] args) {
        int N = 10000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println("연산 횟수: "+cnt++);
            }
        }
    }
}
