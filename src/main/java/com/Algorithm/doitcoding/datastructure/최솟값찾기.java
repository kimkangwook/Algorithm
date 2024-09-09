package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        for (int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());

            // Node 생성
            Node newNode = new Node(i+1,now);

            // 덱에 있는 마지막 요소와 크기 비교하여 작으면 마지막 요소 제거
            while (!deque.isEmpty()&&deque.peekLast().getValue()>now) {
                deque.pollLast();
            }

            // 덱에 저장
            deque.addLast(newNode);

            // 첫번째와 마지막 노드의 인덱스의 차이가 window일 경우 첫번째 노드 제거
            if (i+1-deque.peekFirst().getIndex()>=window) {
                deque.pollFirst();
            }

            bw.write(deque.peekFirst().getValue()+" ");


        }

        bw.flush();
        bw.close();

    }
}

class Node {
    private int index;

    private int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}


