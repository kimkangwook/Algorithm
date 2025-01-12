package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 칵테일 {
    private static boolean[] visited;
    private static ArrayList<cNode>[] A;
    private static long D[];
    private static long lcm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        A = new ArrayList[N];
        D = new long[N];
        lcm = 1;
        for (int i=0;i<N;i++) {
            A[i] = new ArrayList<cNode>();
        }

        for (int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q) / gcd(p, q);
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i=1;i<N;i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i=0;i<N;i++) {
            System.out.print(D[i]/mgcd+" ");
        }


    }

    private static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private static void DFS(int Node) {
        visited[Node] = true;
        for (cNode i :A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

}

class cNode {

    private int b;

    private int p;

    private int q;

    public cNode(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}

