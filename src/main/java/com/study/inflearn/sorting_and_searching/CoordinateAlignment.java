package com.study.inflearn.sorting_and_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoordinateAlignment {

    static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node o) {
            if(this.x==o.x)return this.y-o.y;
            return this.x-o.x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        ArrayList<Node> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Node(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Node node : a) {
            System.out.println(node.x+" "+node.y);
        }
    }
}
