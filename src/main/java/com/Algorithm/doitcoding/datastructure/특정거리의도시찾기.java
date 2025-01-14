package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static int[] visited;

    static ArrayList<Integer>[] A;

    static ArrayList<Integer> answer;

    static int N,M,K, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
         M = sc.nextInt();
         K = sc.nextInt();
         X = sc.nextInt();

        visited = new int[N + 1];
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();

        for (int i=1;i<=N;i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=1;i<=N;i++) {
            visited[i] = -1;
        }
        for (int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
        }
        BFS(X);

        for (int i=1;i<=N;i++) {
            if (visited[i]==K) {
                answer.add(i);
            }
        }
        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int a: answer) {
                System.out.println(a);
            }
        }



    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next: A[now]) {
                if (visited[next]==-1) {
                    queue.add(next);
                    visited[next] = visited[now] +1;
                }
            }
        }
    }

}
