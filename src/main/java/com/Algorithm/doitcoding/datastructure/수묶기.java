package com.Algorithm.doitcoding.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 수묶기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int sum = 0;
        int one = 0;
        int zero = 0;

        for (int i=0;i<N;i++) {
            int number = sc.nextInt();

            if (number>=2) {
                plusQueue.add(number);
            } else if (number==1) {
                one++;
            } else if (number==0) {
                zero++;
            } else {
                minusQueue.add(number);
            }
        }

        while (plusQueue.size()>1) {
            int a = plusQueue.remove();
            int b = plusQueue.remove();
            sum += a * b;
        }

        sum += one;

        while (minusQueue.size()>1) {
            int a = minusQueue.remove();
            int b = minusQueue.remove();
            sum += a * b;
        }

        if (!plusQueue.isEmpty()) sum += plusQueue.remove();

        if (!minusQueue.isEmpty()) {
            if (zero==0) {
                sum += minusQueue.remove();
            }
        }

        System.out.println(sum);


    }


}
