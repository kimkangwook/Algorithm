package com.Algorithm.doitcoding.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque deque = new LinkedList();

        for (int i=N;i>0;i--) {
            deque.add(i);
        }

        while (deque.size()>1) {
            deque.pollLast();
            deque.addFirst(deque.pollLast());
        }

        System.out.println(deque.peek());
    }
}
