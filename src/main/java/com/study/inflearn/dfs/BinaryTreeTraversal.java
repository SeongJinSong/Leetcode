package com.study.inflearn.dfs;


public class BinaryTreeTraversal {
    /**
          1
       2     3
     4   5  6  7
     전위 순회 : 1 2 4 5 3 6 7
     중위 순회 : 4 2 5 1 6 3 7
     후위 순회 : 4 5 2 6 7 3 1 // 병합정렬
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
        BinaryTreeTraversal T = new BinaryTreeTraversal();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        T.dfs(T.root);
    }

    private void dfs(Node root) {
        if(root==null)return;
//        System.out.print(root.data+" "); //전위 순회
        dfs(root.lt);
//        System.out.print(root.data+" "); //중위 순회
        dfs(root.rt);
        System.out.print(root.data+" "); //후위 순회
    }

}
