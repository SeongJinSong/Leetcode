package com.study.inflearn.union_find;

import java.util.Scanner;

public class MakeSureFriends {
    static int[] unf;
    public int find(int v) {
        if(v==unf[v])return v;
        return unf[v] = find(unf[v]);
    }

    public void union(int a, int b) {
        int v1 = find(a);
        int v2 = find(b);
        if (v1 != v2) unf[v1]=v2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i]=i;
        }
        MakeSureFriends T = new MakeSureFriends();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = T.find(a);
        int y = T.find(b);
        if(x==y) System.out.println("YES");
        else System.out.println("NO");
    }
}
