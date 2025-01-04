package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strings = str.split("-");
        int sum = 0;
        for (int i=0;i< strings.length;i++) {
            int temp = mySum(strings[i]);
            if (i==0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);

    }

    public static int mySum(String str) {
        String[] strings = str.split("\\+");
        int sum = 0;
        for (int i=0;i< strings.length;i++) {
            sum += Integer.parseInt(strings[i]);
        }
        return sum;
    }
}
