package com.Algorithm.doitcoding.자료구조.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {

    public static int checkArr;

    public static int[] curArr;

    public static int[] standardArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String text = br.readLine();
        st = new StringTokenizer(br.readLine());
        standardArr = new int[4];
        curArr = new int[4];
        for (int i=0;i<4;i++) {
            standardArr[i] = Integer.parseInt(st.nextToken());
        }
        checkArr = 0;

        String curText = text.substring(0, P);
        for (int i=0;i<curText.length();i++) {
            char c = curText.charAt(i);
            if (c=='A') {
                curArr[0]++;
            } else if (c=='C') {
                curArr[1]++;
            } else if (c=='G') {
                curArr[2]++;
            } else if (c=='T') {
                curArr[3]++;
            }
        }

        for (int i=0;i<4;i++) {
            if (curArr[i]>=standardArr[i]) checkArr++;
        }

        int count = 0;
        if (checkArr==4) {
            count++;
        }
        for (int i=1;i<=S-P;i++) {
            remove(text.charAt(i-1));
            add(text.charAt(i+P-1));

            if (checkArr==4) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void add(char c) {
        if (c=='A') {
            if (curArr[0]==(standardArr[0]-1)) {
                checkArr++;
            }
            curArr[0]++;
        } else if (c=='C') {
            if (curArr[1]==(standardArr[1]-1)) {
                checkArr++;
            }
            curArr[1]++;
        } else if (c=='G') {
            if (curArr[2]==(standardArr[2]-1)) {
                checkArr++;
            }
            curArr[2]++;
        } else if (c=='T') {
            if (curArr[3]==(standardArr[3]-1)) {
                checkArr++;
            }
            curArr[3]++;
        }
    }

    public static void remove(char c) {
        if (c=='A') {
            if (curArr[0]==(standardArr[0])) {
                checkArr--;
            }
            curArr[0]--;
        } else if (c=='C') {
            if (curArr[1]==(standardArr[1])) {
                checkArr--;
            }
            curArr[1]--;
        } else if (c=='G') {
            if (curArr[2]==(standardArr[2])) {
                checkArr--;
            }
            curArr[2]--;
        } else if (c=='T') {
            if (curArr[3]==(standardArr[3])) {
                checkArr--;
            }
            curArr[3]--;
        }
    }
}
