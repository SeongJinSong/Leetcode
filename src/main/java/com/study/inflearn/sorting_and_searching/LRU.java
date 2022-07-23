package com.study.inflearn.sorting_and_searching;

import com.study.inflearn.P;

import java.util.*;

public class LRU {
    //5 9
    //1 2 3 2 6 2 3 5 7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        LRU T = new LRU();
        P.print(T.solution3(s, n, a));
    }

    private ArrayList<Integer> solution(int s, int n, int[] a) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>(n, 0.75f, true);
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for (int i : hm.keySet()) {
            stk.push(i);
        }
        for (int i = 0; i < s; i++) {
            ans.add(stk.pop());
        }
        return ans;
    }
    private ArrayList<Integer> solution2(int s, int n, int[] a) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        for (int i : a) {
            if (lhs.contains(i)) {
                lhs.remove(i);
            }
            lhs.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for (Integer lh : lhs) {
            stk.push(lh);
        }
        for (int i = 0; i < s; i++) {
            ans.add(stk.pop());
        }
        return ans;
    }

    private int[] solution3(int s, int n, int[] a) {
        int[] cache = new int[s];
        for (int x : a) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (cache[i] == x) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = s - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
}
