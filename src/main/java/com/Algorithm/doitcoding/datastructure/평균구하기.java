package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] score = sc.nextLine().split(" ");

        int highScore=0;
        int sum=0;

        for (int i=0;i<score.length;i++) {
            if (highScore<Integer.parseInt(score[i])) {
                highScore = Integer.parseInt(score[i]);
            }
            sum += Integer.parseInt(score[i]);
        }

        System.out.println("평균값 : "+(double)(sum*100)/(size*highScore));
    }
}
