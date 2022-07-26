package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestEndNode {
    /**
          1
       2    3
     4   5
     */
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public static void main(String[] args) {
        ShortestEndNode T = new ShortestEndNode();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.dfs(0, T.root));
        System.out.println("-----");
        System.out.println(T.bfs(T.root));
    }
    private int dfs(int level, Node root) {
        if(root.rt==null&&root.lt==null)return level;
        else if(root.lt==null&&root.rt!=null) return dfs(level + 1, root.rt);
        else if(root.lt!=null&&root.rt==null) return dfs(level + 1, root.lt);
        return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
    }
    private int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur.lt==null&&cur.rt==null)return level;
                if(cur.lt!=null)q.add(cur.lt);
                if(cur.rt!=null)q.add(cur.rt);
            }
            level++;
        }
        return level;
    }
}
