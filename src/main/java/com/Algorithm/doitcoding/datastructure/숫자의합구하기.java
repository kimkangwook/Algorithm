package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 숫자의합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr = "";
        for (int i=0;i<N;i++) {
            arr += Integer.valueOf(br.read()-'0');
        }

        char[] chars = arr.toCharArray();
        int sum=0;
        for (int i=0;i<chars.length;i++) {
            sum+=chars[i] - '0';
        }
        System.out.println(sum);
    }
}
