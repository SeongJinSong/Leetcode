package com.study.inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WeddingCeremony {
    static class Node{
        int time, type;
        public Node(int time, int type){
            this.time=time;
            this.type=type;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Node(sc.nextInt(), 0));
            a.add(new Node(sc.nextInt(), 1));
        }
        a.sort((x, y) -> {
            if (x.time == y.time) return y.type - x.type;
            return x.time - y.time;
        });
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < 2*n; i++) {
            if(a.get(i).type==1)cnt--;
            if (a.get(i).type == 0) {
                ans = Math.max(ans, ++cnt);
            }
        }
        System.out.println(ans);
    }
}
