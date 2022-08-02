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
        int cnt = 1;
        while (q.size()!=1) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (cnt++ % k == 0)  q.poll();
                else q.add(q.poll());
            }
        }
        System.out.println(q.peek());
    }
}
