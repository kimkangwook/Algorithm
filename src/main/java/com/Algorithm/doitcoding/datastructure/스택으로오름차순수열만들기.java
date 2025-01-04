package com.Algorithm.doitcoding.datastructure;


import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class 스택으로오름차순수열만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        int[] array = new int[N];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int m = 1;
        boolean result = true;

        for (int i=0;i<N;i++) {
            int n = array[i];

            while (n>=m) {
                sb.append("+\n");
                stack.push(m);
                m++;
            }

            if (stack.peek().equals(n)) {
                stack.pop();
                sb.append("-\n");
            } else if (stack.peek()>n) {
                System.out.println("NO");
                result = false;
                break;
            }

        }


        if (result) {
            System.out.println(sb);
        }


    }
}
