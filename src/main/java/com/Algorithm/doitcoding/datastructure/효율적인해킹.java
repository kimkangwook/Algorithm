package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.*;

public class 효율적인해킹 {

    private static int N, M;
    private static boolean[] visited;
    private static int[] answer;
    private static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];

        A = new ArrayList[N + 1];
        for (int i=1;i<=N;i++) {
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
        }
        for (int i=1;i<=N;i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }
        int maxValue = 0;
        for (int i=1;i<=N;i++) {
            if (maxValue<answer[i]) {
                maxValue = answer[i];
            }
        }
        for (int i=1;i<=N;i++) {
            if (answer[i]==maxValue) {
               bw.write(i+ " ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
                for (int next: A[now_node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        answer[next]++;
                    }
                }
        }
    }
}
