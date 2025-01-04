package com.Algorithm.doitcoding.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {

    private static ArrayList<Integer>[] array;

    private static boolean[] visited;

    private static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrive = false;
        int N = Integer.parseInt(st.nextToken());
        array = new ArrayList[N];
        visited = new boolean[N];

        for (int i=0;i<N;i++) {
            array[i] = new ArrayList<Integer>();
        }

        int M = Integer.parseInt(st.nextToken());

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            array[S].add(E);
            array[E].add(S);

        }


        for (int i=0;i<N;i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }



    }

    private static void DFS(int a, int n) {
        if (n == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[a] = true;
        for (int i : array[a]) {
            if (!visited[i]) {
                DFS(i, n+1);
            }
        }
        visited[a] = false;
    }
}
