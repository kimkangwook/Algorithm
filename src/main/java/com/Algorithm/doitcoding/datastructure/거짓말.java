package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 거짓말 {

    public static int[] parent;

    public static ArrayList<Integer>[] party;

    public static int[] trueP;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int trueNumber = sc.nextInt();

        parent = new int[N + 1];
        for (int i=1;i<=N;i++) {
            parent[i] = i;
        }

        trueP = new int[trueNumber];

        for (int i=0;i<trueNumber;i++) {
            trueP[i] = sc.nextInt();
        }

        party = new ArrayList[M];

        for (int i=0;i<M;i++) {
            int visitorNumber = sc.nextInt();
            party[i] = new ArrayList<>();
            int firstVisitor = sc.nextInt();
            party[i].add(firstVisitor);

            for (int j=1;j<visitorNumber;j++) {
                int visitor = sc.nextInt();
                union(firstVisitor, visitor);
                party[i].add(visitor);
            }
        }
        int count = 0;

        for (int i=0;i<M;i++) {

            int represent= party[i].get(0);
            boolean checkSame = true;
            for (int j=0;j<trueNumber;j++) {
                if (find(represent)==find(trueP[j])) {
                    checkSame = false;
                }
            }

            if (checkSame) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    public static int find(int a) {
        if (parent[a]==a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

}
