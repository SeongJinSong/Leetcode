package com.study.inflearn.hashmap;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KthLargestNumber {
    static int n, k;
    static int[] a;
    static TreeSet<Integer> ts;
    static int idx=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        ts = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        KthLargestNumber T = new KthLargestNumber();
        T.dfs(0, 0, 0);
        int cnt = 1;
        for (int i : ts){
            if(cnt++==k){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private void dfs(int depth, int start, int sum) {
        if (depth == 3) {
            ts.add(sum);
            return;
        }
        for (int i = start; i < n; i++) {
            dfs(depth + 1, i + 1, sum + a[i]);
        }
    }
}
