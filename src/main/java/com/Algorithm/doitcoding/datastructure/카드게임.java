package com.Algorithm.doitcoding.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> queue = new LinkedList<>();

        for (int i=N;i>=1;i--) {
            queue.offer(i);
        }

        while (queue.size()>1) {
            // 맨 윗장 버리기
            queue.pollLast();

            // 맨 윗장을 맨 아랫장으로 집어 넣기
            queue.addFirst(queue.pollLast());
        }
        System.out.println(queue.pollLast());
    }
}
