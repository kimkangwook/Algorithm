package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수구하기 {

    public static ArrayList<Integer>[] arrays;

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arrays = new ArrayList[N + 1];

        for (int i=1;i<N+1;i++) {
            arrays[i] = new ArrayList<Integer>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arrays[S].add(E);
            arrays[E].add(S);
        }

        int count = 0;
        for (int i=1;i<N+1;i++) {

            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }

    public static void DFS(int i) {
        if (!visited[i]) {
            visited[i] = true;

            for (Integer j : arrays[i]) {

                if (visited[j]) {
                    continue;
                } else {
                    DFS(j);
                }
            }

        }
    }
}
