package com.Algorithm.doitcoding.datastructure;

import java.io.*;
import java.util.*;

public class AxByC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long gcd = gcd(A, B);

        if (C%gcd!=0) {
            System.out.println(-1);
        } else {
            long multiply = C / gcd;
            long[] solve = DFS(A, B);
            System.out.print(solve[0]*multiply+" "+solve[1]*multiply);
        }


    }

    public static long[] DFS(long A, long B) {
        long[] solve =new long[2];
        if (B==0) {
            solve[0] = 1;
            solve[1] = 0;
            return solve;
        } else {
            long mock = A / B;
            long[] prevSolve = DFS(B,A%B);
            solve[0] =prevSolve[1];
            solve[1] = prevSolve[0] - prevSolve[1] * mock;
            return solve;
        }
    }

    public static long gcd(long a, long b) {
        if (a%b==0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}

//public class AxByC {
//
//    private static Stack<Integer> stack = new Stack();
//
//    private static int prevX;
//    private static int prevY;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//
//        int gcd = gcd(A, B);
//
//        if (C%gcd!=0) {
//            System.out.println(-1);
//        } else {
//            int multiply = C / gcd;
//            gcdUclid(A,B);
//            prevX = 1;
//            prevY = 0;
//
//            while (!stack.isEmpty()) {
//                int q = stack.pop();
//
//                int x = prevY;
//                int y = prevX - prevY * q;
//
//                prevX = x;
//                prevY = y;
//            }
//            System.out.print(prevX*multiply+ " "+ prevY*multiply);
//
//
//        }
//
//    }
//
//    public static int gcd(int a, int b) {
//        if (a%b==0) {
//            return b;
//        } else {
//            return gcd(b, a % b);
//        }
//    }
//
//    public static void gcdUclid(int a, int b) {
//        if (a%b!=0) {
//            stack.push(a / b);
//            gcdUclid(b,a%b);
//        } else {
//            stack.push(a / b);
//        }
//    }
//
//}
