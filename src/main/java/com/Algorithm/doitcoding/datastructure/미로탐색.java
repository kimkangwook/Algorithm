package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static boolean[][] visited;
    private static int[][] A;

    private static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        A = new int[N][M];

        for (int i=0;i<N;i++) {
            String numbers = br.readLine();

            for (int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(numbers.substring(j, j + 1));
            }
        }

        BFS();
        System.out.println(A[N-1][M-1]);
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k=0;k<=3;k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x>=0 && y>=0 && x<N && y<M) {
                    if (A[x][y]==1 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }

                }
            }


        }
    }



}
