package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    private static int[] count;

    private static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = new int[N + 1];

        for (int i=1;i<=N;i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
        }

        BFS(X);

        for (int i=1;i<=N;i++) {
            if (count[i]==K) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int a :answer) {
                System.out.println(a);
            }
        }






    }

    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int next: A[start]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count[next] = count[start] + 1;
                    queue.add(next);
                }
            }
        }

    }

}
