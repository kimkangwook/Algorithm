package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        int[][] originals = new int[N + 1][N+1];

        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1;j<=N;j++) {
                originals[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] D = new int[N + 1][N + 1];
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + originals[i][j];
            }
        }

        for (int i=0;i<number;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);

        }


    }
}
