package com.Algorithm.doitcoding.자료구조.스택;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값힙_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });
        for (int i=0;i<N;i++) {
            int caculation = sc.nextInt();

            if (caculation==0) {
                if (queue.isEmpty()) {
                    sb.append("0").append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else {
                queue.add(caculation);
            }
        }

        System.out.println(sb);
    }
}
