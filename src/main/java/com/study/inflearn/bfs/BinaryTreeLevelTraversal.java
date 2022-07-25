package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
    /**
           1
       2      3
     4   5  6   7
     레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
     */
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt=rt=null;
        }
    }
    Node root;
    public static void main(String[] args) {
        BinaryTreeLevelTraversal T = new BinaryTreeLevelTraversal();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        T.bfs(T.root);
    }

    private void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.println("level = " + level);
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur == null) continue;
                System.out.print(cur.data+" ");
                if(cur.lt!=null)q.add(cur.lt);
                if(cur.rt!=null)q.add(cur.rt);
            }
            level++;
            System.out.println();
        }
    }
}
