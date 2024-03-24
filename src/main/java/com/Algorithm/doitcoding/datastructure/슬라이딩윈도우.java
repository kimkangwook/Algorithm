package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩윈도우 {
    static int checkArray[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] A = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        checkArray = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        int Result = 0;

        for (int i=0;i<4;i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
            if (checkArray[i]==0) {
                checkSecret++;
            }
        }

        for (int i=0;i<M;i++) {
            Add(A[i]);
        }

        if (checkSecret==4)
            Result++;

        for (int i=M;i<N;i++) {
            int j = i-M;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret==4)
                Result++;
        }
        System.out.println(Result);
        br.close();




    }

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if (myArr[0] == checkArray[0])
                    checkSecret++;
                break;
            case 'C' :
                myArr[1]++;
                if (myArr[1] == checkArray[1])
                    checkSecret++;
                break;
            case 'G' :
                myArr[2]++;
                if (myArr[2]==checkArray[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArray[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if (myArr[0] == checkArray[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if (myArr[1] == checkArray[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if (myArr[2]==checkArray[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArray[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
