package com.Algorithm.doitcoding.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기 {

    public static ArrayList<Integer>[] lists;

    public static ArrayList<Integer> answer;

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        lists = new ArrayList[N + 1];
        arr = new int[N + 1];
        answer = new ArrayList<>();

        for (int i=1;i<=N;i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lists[a].add(b);
            arr[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1;i<=N;i++) {
            if (arr[i]==0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int number = queue.poll();
            answer.add(number);
            for (int next: lists[number]) {
                if (--arr[next]==0) {
                    queue.add(next);
                }
            }
        }
        for (int number :answer) {
            System.out.print(number+" ");
        }






    }
}
