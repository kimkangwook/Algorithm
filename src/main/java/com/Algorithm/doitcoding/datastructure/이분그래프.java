package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프 {

    private static ArrayList<Integer>[] A;

    private static int[] visited;

    private static boolean isBreak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            visited = new int[V + 1];
            isBreak = false;

            for (int j=1;j<=V;j++) {
                A[j] = new ArrayList();
                visited[j] = -1;
            }

            for (int j=0;j<E;j++) {
                st = new StringTokenizer(br.readLine());
                int Start = Integer.parseInt(st.nextToken());
                int End = Integer.parseInt(st.nextToken());

                A[Start].add(End);
                A[End].add(Start);
            }

            for (int j=1;j<=V;j++) {
                if (isBreak) {
                    break;
                } else {
                    DFS(j);
                }
            }

            if (isBreak) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }


    private static void DFS(int Node) {

        for (int next : A[Node]) {
            if (visited[next]==-1) {
                visited[next] = (visited[Node] + 1) % 2;
                DFS(next);
            } else {
                if (visited[next]==visited[Node]) {
                    isBreak = true;
                }
            }
        }
    }



}
