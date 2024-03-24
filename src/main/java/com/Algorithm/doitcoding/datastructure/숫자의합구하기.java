package com.Algorithm.doitcoding.datastructure;

import java.util.Scanner;

public class 숫자의합구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberSize = sc.nextInt();
        // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for (int i=0;i<numberSize;i++) {
            sum += cNum[i]-'0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }

        System.out.println("나머지 합계 : " +sum);
    }
}
