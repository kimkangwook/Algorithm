package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙구현하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue priorityQueue = new PriorityQueue<Integer>((o1, o2) -> {
            int abs_o1 = Math.abs(o1);
            int abs_o2 = Math.abs(o2);
            if (abs_o1>abs_o2) {
                return 1;
            } else {
                if (abs_o1 == abs_o2) {
                    return o1 > o2 ? 1 : -1;
                }
                return -1;
            }
        });
        for (int i=0;i<N;i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(priorityQueue.poll()).append('\n');
                }
            } else {
                priorityQueue.add(n);
            }
        }
        System.out.println(sb);
    }
}
