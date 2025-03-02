package com.Algorithm.doitcoding.자료구조.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String text = br.readLine();
        String first_text = text.substring(0, P);
        int[] ABCD = new int[4];
        for (int i=0;i<first_text.length();i++) {
            char c = first_text.charAt(i);
            if (c=='A') {
                ABCD[0]++;
            } else if (c=='C') {
                ABCD[1]++;
            } else if (c=='G') {
                ABCD[2]++;
            } else if (c=='T') {
                ABCD[3]++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] need_ABCD = new int[4];
        for (int i=0;i<4;i++) {
            need_ABCD[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        if (ABCD[0]>=need_ABCD[0] && ABCD[1]>=need_ABCD[1] && ABCD[2]>=need_ABCD[2] && ABCD[3]>=need_ABCD[3]) count++;



        for (int i=1;i<=text.length()-P;i++) {
            char minus = text.charAt(i - 1);
            char plus = text.charAt(i - 1 + P);

            if (minus=='A') {
                if (ABCD[0]!=0) ABCD[0]--;
            } else if (minus=='C') {
                if (ABCD[1]!=0) ABCD[1]--;
            } else if (minus=='G') {
                if (ABCD[2]!=0) ABCD[2]--;
            } else if (minus=='T') {
                if (ABCD[3]!=0) ABCD[3]--;
            }

            if (plus=='A') {
                ABCD[0]++;
            } else if (plus=='C') {
                ABCD[1]++;
            } else if (plus=='G') {
                ABCD[2]++;
            } else if (plus=='T') {
                ABCD[3]++;
            }

            if (ABCD[0]>=need_ABCD[0] && ABCD[1]>=need_ABCD[1] && ABCD[2]>=need_ABCD[2] && ABCD[3]>=need_ABCD[3]) count++;
        }
        System.out.println(count);

    }
}
