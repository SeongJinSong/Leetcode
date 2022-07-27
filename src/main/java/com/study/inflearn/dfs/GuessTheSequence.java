package com.study.inflearn.dfs;

import java.util.Scanner;

public class GuessTheSequence {
    static int n, f;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        a = new int[n];
        GuessTheSequence T = new GuessTheSequence();
        T.dfs(0, f);
    }

    private void dfs(int depth, int val) {
        if (depth == n) {
            return;
        }
    }
}
