package com.study.inflearn.union_find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumSpanningTree {
    static class Edge{
        int start, end, weight;
        public Edge(int start, int end, int weight) {
            this.start=start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int ans = 0;
    static int[] unf;

    public int find(int v) {
        if(unf[v]==v)return v;
        return unf[v] = find(unf[v]);
    }
    public void union(int from, int to, int weight) {
        int v1 = find(from);
        int v2 = find(to);
        if(v1!=v2){
            unf[v1]=v2;
            ans+=weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i]=i;
        }
        int m = sc.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        MinimumSpanningTree T = new MinimumSpanningTree();
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        edges.sort(Comparator.comparingInt(a -> a.weight));
        for (Edge e : edges) {
            T.union(e.start, e.end, e.weight);
        }
        System.out.println(ans);
    }
}
