package com.study.inflearn.greedy;

import java.util.*;

public class MaximumIncomeSchedule {
    static class Node{
        int val, due;
        public Node(int val, int due) {
            this.val=val;
            this.due=due;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int due = sc.nextInt();
            m.computeIfAbsent(due, k -> new ArrayList<>());
            m.get(due).add(val);
            max = Math.max(max, due);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        while (max>0) {
            //due가 max보다 크거나 같은것중 제일 큰것 선택
            if(m.get(max)!=null){
                pq.addAll(m.get(max));
            }
            ans += pq.peek()!=null?pq.poll():0;
            max--;
        }
        System.out.println(ans);
    }
}
