package com.study.inflearn.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int ans = 0;
        while(!q.isEmpty()){
            for (int i = 1; i < k; i++) q.add(q.poll());
            q.poll();
            if(q.size()==1) ans = q.poll();
        }
        System.out.println(ans);
    }
}
