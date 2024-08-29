package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            Node node = new Node(i, number);

            while (!deque.isEmpty() && deque.peekLast().getNumber() > node.getNumber()) {
                deque.pollLast();
            }
            deque.addLast(node);

            if (deque.peekLast().getIndex() - deque.peekFirst().getIndex() >= window) {
                deque.pollFirst();
            }

            // 맨앞 노드의 number 출력
            bw.write(deque.peekFirst().getNumber() + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Node {
    private Integer index;

    private Integer number;

    public Node(Integer index, Integer number) {
        this.index = index;
        this.number = number;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Integer getNumber() {
        return this.number;
    }
}
