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
        System.out.println();
        if(ts.size()<k) System.out.println(-1);
        //treeSet 은 정렬을 하고, red black tree 로 내부적으로 구성을 한다.
        //pollFirst 하면 이진수를 밸런스 트리로 만드는 작용을 하기 때문에 성능에 불리하다.
        for (int i = 0; i < k - 1; i++) {
            ts.pollFirst();
        }
        System.out.println(ts.first());
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
