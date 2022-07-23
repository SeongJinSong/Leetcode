package com.study.inflearn.two_pointers;

import java.util.*;

public class MaxLengthSequentialSubArray {
    //14 2
    //1 1 0 0 1 1 0 1 1 0 1 1 0 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        MaxLengthSequentialSubArray T = new MaxLengthSequentialSubArray();
        System.out.println(T.solution2(n, k, a));
    }

    private int solution(int n, int k, int[] a) {
        int lt = 0, rt = 0;
        int ans = 0, cnt = 0;
        while (rt < n) {
            if (a[rt] == 0) {
                if (cnt >= k) {
                   while(cnt>=k){
                       if(a[lt++]==0)cnt--;
                   }
                }
                cnt++;
            }
            if (ans < rt - lt + 1) {
                ans = rt - lt + 1;
            }
            rt++;
        }
        return ans;
    }
    private int solution2(int n, int k, int[] a) {
        int lt = 0, rt = 0, ans = 0;
        Queue<Integer> q = new LinkedList<>();
        while (rt < n) {
            if (a[rt] == 0) {
                if (q.size() >= k) {
                    lt=q.poll()+1;
                }
                q.add(rt);
            }
            ans = Math.max(ans, rt - lt + 1);
            rt++;
        }
        return ans;
    }

}
