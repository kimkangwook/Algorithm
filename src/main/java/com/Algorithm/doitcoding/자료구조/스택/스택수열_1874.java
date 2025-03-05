package com.Algorithm.doitcoding.자료구조.스택;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열_1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 1;
        boolean 가능 = true;
        for (int i=0;i<N;i++) {
            int number = sc.nextInt();

            // 스택에 새로운 값 넣기
            while (index<=number) {
                stack.push(index++);
                sb.append('+').append('\n');
            }

            // 만약 index보다 number 작을 시 그만 넣고 number가 꺼내는 값 같을 시 꺼내기
            if (stack.peek()==number) {
                stack.pop();
                sb.append('-').append('\n');
            } else {
                가능 = false;
                break;
            }
        }
        if (!가능) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }


    }
}
