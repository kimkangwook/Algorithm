package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] checked;

    static boolean isBreak = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            checked = new int[V + 1];
            isBreak = false;
            for (int j=1;j<V+1;j++) {
                A[j] = new ArrayList<>();
            }

            for (int j=0;j<E;j++) {
                st = new StringTokenizer(br.readLine());
                int Start = Integer.parseInt(st.nextToken());
                int End = Integer.parseInt(st.nextToken());

                A[Start].add(End);
                A[End].add(Start);
            }

            for (int s=1;s<=V;s++) {
                if (isBreak) {
                    break;
                } else {
                    DFS(s);
                }
            }

            if (isBreak) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }

    public static void DFS(int Node) {
            visited[Node] = true;
            for (int next : A[Node]) {
                if (!visited[next]) {
                    // 방문 안한 노드일때
                    checked[next] = (checked[Node]+1) % 2;
                    DFS(next);
                } else {
                    // 방문한 노드일때
                    int q = (checked[Node] + 1) % 2;
                    if (q!=checked[next]) {
                        isBreak = true;
                    }
                }
            }

    }

}
