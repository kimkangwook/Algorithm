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
        int start = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i=1;i<=N;i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int start_point = Integer.parseInt(st.nextToken());
            int end_point = Integer.parseInt(st.nextToken());

            arrayLists[start_point].add(end_point);
            arrayLists[end_point].add(start_point);
        }

        for (int i=1;i<=N;i++) {
            Collections.sort(arrayLists[i]);
        }

        DFS(start);
        visited = new boolean[N + 1];
        sb.append('\n');
        BFS(start);
        System.out.println(sb);

    }

    public static void DFS(int number) {

        visited[number] = true;
        sb.append(number + " ");

        for (int next: arrayLists[number]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        visited[number] = true;

        while (!queue.isEmpty()) {
            int newNumber = queue.poll();
            sb.append(newNumber + " ");

            for (int next: arrayLists[newNumber]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
