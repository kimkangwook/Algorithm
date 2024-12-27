package com.Algorithm.doitcoding.datastructure;

import java.util.*;

public class 트리지름구하기 {

    static ArrayList<Edge>[] A;

    static boolean[] visited;

    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        A = new ArrayList[N+1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i=1;i<=N;i++) {
            int n = sc.nextInt();
            A[n] = new ArrayList<Edge>();

            while (true) {
                int a = sc.nextInt();
                if (a==-1) {
                    break;
                }
                int b = sc.nextInt();

                Edge edge = new Edge(a, b);
                A[n].add(edge);
            }
        }

        BFS(1);
        int Max = 1;
        for (int i=2;i<=N;i++) {
            if (distance[Max]<distance[i]) {
                Max = i;
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    public static void BFS(int i) {
        Queue<Integer> queue = new LinkedList();
        visited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()) {
            int pollNumber = queue.poll();

            for (Edge edge: A[pollNumber]) {
                int number = edge.number;
                int value = edge.value;
                if (!visited[number]) {
                    visited[number] = true;
                    distance[number] = value + distance[pollNumber];
                    queue.add(number);
                }
            }
        }

    }
}

class Edge {
    int number;

    int value;

    public Edge(int number, int value) {
        this.number = number;
        this.value = value;
    }

}