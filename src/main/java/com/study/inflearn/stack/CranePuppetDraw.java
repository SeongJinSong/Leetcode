package com.study.inflearn.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class CranePuppetDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        HashMap<Integer, Stack<Integer>> boardHM =new HashMap<>();
        for (int i = 0; i < n; i++) {
            boardHM.put(i, new Stack<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if(board[i][j]!=0)boardHM.get(j).add(board[i][j]);
            }
        }
        int m = sc.nextInt();
        int[] pick = new int[m];
        for (int i = 0; i < m; i++) {
            pick[i] = sc.nextInt()-1;
        }
        int ans = 0;
        Stack<Integer> bucketStk =new Stack<>();
        for (int i = 0; i < m; i++) {
            if(boardHM.get(pick[i]).isEmpty())continue;
            int pickedPuppet = boardHM.get(pick[i]).pop();
            if(!bucketStk.isEmpty()&&bucketStk.peek()==pickedPuppet) {
                bucketStk.pop();
                ans+=2;
            }
            else bucketStk.add(pickedPuppet);
        }
        System.out.println(ans);

    }
}
