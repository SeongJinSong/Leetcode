package com.study.inflearn.union_find;

import java.util.*;

public class MinimumSpanningTree_Prim {
    static class Edge{
        int next, weight;
        public Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    static int ans;
    static int[] check;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[v + 1];
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));//처음 문제 풀때 양방향을 잊어서 고생했다.
        }
        MinimumSpanningTree_Prim T = new MinimumSpanningTree_Prim();
        T.bfs(1);
        System.out.println(ans);
    }

    private void bfs(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        check[v]=1;
        pq.addAll(graph.get(v));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(check[cur.next]==1)continue;
            check[cur.next]=1;
            ans+=cur.weight;
            pq.addAll(graph.get(cur.next));
        }
    }
}
