package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트프로그램1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        for (int i=0;i<N;i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(A);
        int Max = 0;
        // 앞으로 많이 이동한 숫자를 찾는 이유는 이 숫자외에 다른 숫자들은 이미 이동을 끝냈기 때문이다
        for (int i=0;i<N;i++) {
            if (Max < A[i].index - i) {
                Max = A[i].index - i;
            }
        }
        System.out.println(Max+1);
    }


}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData mData) {
        return this.value - mData.value;
    }
}
