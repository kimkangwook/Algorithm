package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 스택 푸시
        stack.push(0);

        for (int i=1;i<N;i++) {
            // 현재 수열의 값과 스택의 top에 해당하는 수열의 값 비교 후 만약 현재 수열의 값이 크다면
            // 현재 top index pop 후 top index에 해당하는 값을 정답 배열 index에 해당하는 값 넣어주기
            // 이후 현재 수열의 인덱스를 스택에 push
            while(!stack.isEmpty()&&(arr[i] > arr[stack.peek()])) {
                int index = stack.pop();
                ans[index] = arr[i];
            }
            stack.push(i);
        }

        // 스택에 남아있는 인덱스를 pop하여 정답배열에 -1 채우기
        while (!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = -1;
        }

        for (int i=0;i<N;i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
