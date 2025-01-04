package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Data[] arr = new Data[N];

        for (int i=0;i<N;i++) {
            arr[i] = new Data(i,Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i=0;i<N;i++) {
            int difference = arr[i].getIndex() - i;
            if (max < difference) {
                max = difference;
            }
        }

        System.out.println(max+1);

    }
    

}

class Data implements Comparable<Data> {

    private int index;

    private int number;

    public Data(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Data o) {
        return this.number - o.number;
    }
}
