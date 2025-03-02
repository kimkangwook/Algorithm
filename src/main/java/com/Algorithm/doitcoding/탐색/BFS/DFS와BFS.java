package com.Algorithm.doitcoding.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {

    public static ArrayList<Integer>[] arrayLists;

    public static boolean[] visited;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arrayLists = new ArrayList[N + 1];
        for (int i=1;i<=N;i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }

        for (int i=1;i<=N;i++) {
            Collections.sort(arrayLists[i]);
        }

        DFS(V);
        visited = new boolean[N + 1];
        sb.append('\n');
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int V) {
        visited[V] = true;
        sb.append(V).append(' ');
        for (int next: arrayLists[V]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');
            for (int next : arrayLists[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }



}
