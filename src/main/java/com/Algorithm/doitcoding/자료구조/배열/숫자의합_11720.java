package com.Algorithm.doitcoding.자료구조.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 숫자의합_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sb = br.readLine();
        int sum = 0;

        for (byte var: br.readLine().getBytes()) {
            int n = var - '0';
            sum += n;
        }
        System.out.println(sum);

    }
}
