package com.Algorithm.doitcoding.datastructure;


import java.util.*;

public class DFS와BFS프로그램 {

    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i=1;i<=N;i++) {
            A[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N + 1];

        int M = sc.nextInt();
        int Start = sc.nextInt();

        for (int i=0;i<M;i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            A[s].add(e);
            A[e].add(s);
        }

        for (int i=1;i<=N;i++) {
            Collections.sort(A[i]);
        }

        DFS(Start);
        visited = new boolean[N + 1];
        System.out.println();
        BFS(Start);
    }

    public static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i:A[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");

            for (int i: A[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }


}
