package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 물통 {

    private static int[] Receiver = {0,0,1,1,2,2};

    private static int[] Sender = {1, 2, 0, 2, 0, 1};

    private static boolean[] answer;

    private static boolean[][] visited;

    private static int[] now;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];
        now = new int[]{A, B, C};
        BFS();

        for (int i=0;i<201;i++) {
            if (answer[i]) System.out.print(i+" ");
        }

    }

    public static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        answer[now[2]] = true;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            AB water = queue.poll();
            int waterA = water.A;
            int waterB = water.B;
            int waterC = now[2]-waterA-waterB;

            for (int k=0;k<6;k++) {
                int[] next = new int[]{waterA, waterB, waterC};

                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;

                if (next[Receiver[k]]>now[Receiver[k]]) {
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    if (next[0]==0) answer[next[2]] = true;
                }
            }


        }

    }
}

class AB {
    int A;
    int B;

    public AB(int a, int b) {
        A = a;
        B = b;
    }
}


