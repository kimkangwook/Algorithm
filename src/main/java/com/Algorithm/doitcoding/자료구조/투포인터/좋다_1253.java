package com.Algorithm.doitcoding.자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int count = 0;
        for (int i=0;i<N;i++) {
            int start_index = 0;
            int end_index = N-1;

            while (start_index<end_index) {

                if (array[start_index] + array[end_index] == array[i]) {
                    if (start_index!=i && end_index!=i) {
                        count++;
                        break;
                    } else if (start_index==i) {
                        start_index++;
                    } else if (end_index==i) {
                        end_index--;
                    }
                } else if (array[start_index] + array[end_index] > array[i]) {
                    end_index--;
                } else {
                    start_index++;
                }
            }
        }
        System.out.println(count);
    }
}
