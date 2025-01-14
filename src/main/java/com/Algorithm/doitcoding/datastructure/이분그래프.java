package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분그래프 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int t = 0;t<N;t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int i=1;i<=V;i++) {
                A[i] = new ArrayList<Integer>();
            }
            for (int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int Start = Integer.parseInt(st.nextToken());
                int End = Integer.parseInt(st.nextToken());
                A[Start].add(End);
                A[End].add(Start);
            }

            for (int i=1;i<=V;i++) {
                if (isEven) {
                    DFS(i);
                } else
                    break;
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                check[i] = (check[node]+1)%2;
                DFS(i);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
