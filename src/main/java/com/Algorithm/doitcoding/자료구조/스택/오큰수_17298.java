package com.Algorithm.doitcoding.자료구조.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] current = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            current[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> queue = new Stack<>();

        for (int i=0;i<N;i++) {

            // queue 비었을 시 넣기
            // 반복문 pop - A[top] < A[index] 일시 pop하고 A[top]에 A[index] 값 넣기
                while (!queue.isEmpty() && current[queue.peek()]<current[i]) {
                    int pop = queue.pop();
                    answer[pop] = current[i];
                }
                // 조건이 아닐 시 그냥 index를 push하고 break;
                queue.push(i);

        }

        // A 배열 둘러보면서 값이 0인 녀석들 모두 -1로 고쳐주기;
        for (int i=0;i<N;i++) {
            if (answer[i]==0)  {
                sb.append(-1).append(" ");
            } else {
                sb.append(answer[i]).append(" ");
            }
        }
        System.out.println(sb);


    }
}
