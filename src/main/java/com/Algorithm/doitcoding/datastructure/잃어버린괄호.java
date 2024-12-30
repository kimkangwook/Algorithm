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
        String example = br.readLine();
        String[] str = example.split("-");
        int answer = 0;
        for (int i=0;i< str.length;i++) {
            int temp = mySum(str[i]);
            if (i==0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }
    
    static int mySum(String a) {
        int sum = 0;
        String[] temp = a.split("\\+");
        for (int i=0;i<temp.length;i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
