package com.Algorithm.doitcoding.자료구조.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최솟값찾기_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Board> queue = new LinkedList<>();
        for (int i=0;i<N;i++) {
            long number = Long.parseLong(st.nextToken());
            Board board = new Board(i+1, number);

            // board를 추가한다
            queue.addLast(board);
            // board의 number를 이전 number와 비교해서 작을 경우 이전 board를 제거한다(while문)
            while (true) {
                Board newBoard = queue.pollLast();
                if (queue.isEmpty()) {
                    queue.addLast(newBoard);
                    break;
                } else {
                    Board preBoard = queue.pollLast();
                    if (newBoard.getNumber()<=preBoard.getNumber()) {
                        queue.addLast(newBoard);
                    } else {
                        queue.addLast(preBoard);
                        queue.addLast(newBoard);
                        break;
                    }
                }
            }
            // 만약 첫번째 board의 인덱스와 마지막 board의 인덱스를 비교했을 경우 L이상 차이날 경우 첫번째 board 없애준다.
            if (queue.peekLast().getIndex()-queue.peekFirst().getIndex()>=L) {
                queue.pollFirst();
            }

            // 제일 첫번째 board의 number를 내뱉는다.
            sb.append(queue.peekFirst().getNumber()).append(" ");
        }
        System.out.println(sb);

    }

}


class Board {
    public int index;
    public long number;

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

