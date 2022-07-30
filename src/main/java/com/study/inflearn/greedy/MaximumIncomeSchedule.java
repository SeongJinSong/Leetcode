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
        ArrayList<Node> a = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int due = sc.nextInt();
            m.computeIfAbsent(due, k -> new ArrayList<>()).add(val);
            max = Math.max(max, due);
            a.add(new Node(val, due));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int level = max;
        while (level>0) {
            //due가 level보다 크거나 같은것중 제일 큰것 선택
            if(m.get(level)!=null){
                pq.addAll(m.get(level));
            }
            ans += pq.peek()!=null?pq.poll():0;
            level--;
        }
        System.out.println(ans);
        System.out.println("----------");
        ans = 0;
        pq.clear();
        a.sort((x, y) -> y.due - x.due);
        int cur=0;
        for (int i = max; i >0; i--) {
            for (; cur < n; cur++) {
                if(a.get(cur).due<i)break;
                pq.add(a.get(cur).val);
            }
            ans+=pq.peek()!=null?pq.poll():0;
        }
        System.out.println(ans);
    }
}
