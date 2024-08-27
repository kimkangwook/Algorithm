package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩윈도우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] chars = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] condition = new int[4];
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i=0;i<M;i++) {
            if (chars[i] == 'A') {
                condition[0]++;
            } else if (chars[i] == 'C') {
                condition[1]++;
            } else if (chars[i] == 'G') {
                condition[2]++;
            } else if (chars[i] == 'T') {
                condition[3]++;
            }
        }

        if (condition[0]>=A&&condition[1]>=C&&condition[2]>=G&&condition[3]>=T) {
            count++;
        }

        for (int i=1;i<=N-M;i++) {
            char plus = chars[M + i - 1];
            char minus = chars[i - 1];


            if (plus=='A') {
                condition[0]++;
            } else if (plus=='C') {
                condition[1]++;
            } else if (plus=='G') {
                condition[2]++;
            } else if (plus=='T') {
                condition[3]++;
            }

            if (minus=='A') {
                condition[0]--;
            } else if (minus=='C') {
                condition[1]--;
            } else if (minus=='G') {
                condition[2]--;
            } else if (minus=='T') {
                condition[3]--;
            }

            if (condition[0]>=A&&condition[1]>=C&&condition[2]>=G&&condition[3]>=T) {
                count++;
            }

        }
        System.out.println(count);
    }
}
