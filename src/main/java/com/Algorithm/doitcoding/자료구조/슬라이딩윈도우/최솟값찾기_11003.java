package com.Algorithm.doitcoding.자료구조.슬라이딩윈도우;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Board> queue = new LinkedList<>();

        for (int i=0;i<N;i++) {
            // Board 생성
            Board newBoard = new Board(i + 1, Long.parseLong(st.nextToken()));

            // 큐에 집어넣기전에 최근 큐 빼내서 number 비교
            // number가 작을 시 이전 Board 삭제 후 그 이전 Board 빼내서 number 비교 (반복)
            while (true) {
                if (queue.isEmpty()) {
                    break;
                }

                Board prevBoard = queue.peekLast();
                if (prevBoard.getNumber() >= newBoard.getNumber()) {
                    queue.removeLast();
                } else {
                    break;
                }
            }

            // 큐 삽입 시 맨 처음 큐의 index와 비교해서 비교해서 L이상 차이나면 처음 Board 삭제
            if (!queue.isEmpty()) {
                if (newBoard.getIndex()-queue.peekFirst().getIndex()>=L) queue.removeFirst();
            }

            // 큐에 Board 삽입
            queue.addLast(newBoard);

            // 맨 처음 Board의 number 내뱉기
            sb.append(queue.peekFirst().getNumber()).append(" ");
        }
        System.out.println(sb);


    }

}

class Board {
    int index;
    long number;

    public Board(int index, long number) {
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public long getNumber() {
        return number;
    }
}



