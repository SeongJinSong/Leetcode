package com.study.inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DijkstraAlgorithm {
    static class Edge{
        int start, end, weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Edge>> nodes = new ArrayList<>();
    static int n, m;
    static int[] dist;
    static HashSet<String> check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        check = new HashSet<>();

        for (int i = 0; i <= n+1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            nodes.get(start).add(new Edge(start, end, weight));
        }
        DijkstraAlgorithm T = new DijkstraAlgorithm();
        dist[1]=0;
        T.dfs(0, 1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(i+" : "+(dist[i]!=Integer.MAX_VALUE?dist[i]:"impossible"));
        }
    }

    private void dfs(int depth, int idx) {
        if(depth==n)return;
        ArrayList<Edge> edges = nodes.get(idx);
        for (Edge e : edges) {
            if(check.contains(depth+" "+e.start+" "+e.end))continue;
            check.add(depth+" "+e.start + " " + e.end);
            if(dist[e.end]==Integer.MAX_VALUE) dist[e.end] = dist[e.start] + e.weight;
            else dist[e.end]=Math.min(dist[e.end], dist[e.start] + e.weight);
            dfs(depth+1, e.end);
        }
    }
}
