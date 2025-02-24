package com.Algorithm.doitcoding.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

    public static boolean[] visited;

    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        arrayList = new ArrayList[N + 1];
        for (int i=1;i<=N;i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList[start].add(end);
            arrayList[end].add(start);
        }
        int count = 0;

        for (int i=1;i<=N;i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int number) {
        if (visited[number]) {
            return;
        }

        visited[number] = true;
        for (int next : arrayList[number]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

}
