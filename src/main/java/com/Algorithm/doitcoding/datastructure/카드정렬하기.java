package com.Algorithm.doitcoding.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0;i<N;i++) {
            queue.add(sc.nextInt());
        }

        int sum = 0;

        while (queue.size()>1) {
            int a = queue.remove();
            int b = queue.remove();

            sum += a + b;
            queue.add(a + b);
        }
        System.out.println(sum);

    }
}
