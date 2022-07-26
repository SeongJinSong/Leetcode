package com.study.inflearn.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {
    static int level = 0;
    static int e;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        e = sc.nextInt();
        FindCalf T = new FindCalf();
        T.bfs(s);
        System.out.println(level);
        System.out.println("-----");
        System.out.println(T.bfs2(s, e));
    }

    private void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(s);
        hs.add(s);
        loop:while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if(cur==e)break loop;
                checkAndAdd(q, hs, cur-1);
                checkAndAdd(q, hs, cur+1);
                checkAndAdd(q, hs, cur+5);
            }
            level++;
        }
    }

    private void checkAndAdd(Queue<Integer> q, HashSet<Integer> hs, int next) {
        if (!hs.contains(next)) {
            hs.add(next);
            q.add(next);
        }
    }

    static int[] check;

    /**
     * next에서 찾는것이 좀더 시간복잡도에서 효율적이다.
     */
    private int bfs2(int s, int e) {
        check = new int[10001];
        int[] diffs = {1, -1, 5};
        Queue<Integer> q = new LinkedList<>();
        check[s]=1;
        q.offer(s);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int diff : diffs) {
                    int next = cur + diff;
                    if(next==e) return level+1;
                    if (next >= 1 && next <= 10000 && check[next] == 0) {
                        check[next] = 1;
                        q.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
