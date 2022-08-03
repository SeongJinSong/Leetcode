package com.study.inflearn.string;

import com.study.inflearn.P;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestCharacterDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArr = s.split(" ");
        int[] a = new int[sArr[0].length()];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if(sArr[0].charAt(i)==sArr[1].charAt(0)){
                a[i]=0;
                q.add(i);
            }
            else a[i]=Integer.MAX_VALUE;
        }
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if(q.peek()==null)continue;
                int cur = q.poll();
                for (int j : new int[]{1, -1}) {
                    int nextIdx = cur + j;
                    if(nextIdx<0||nextIdx>=a.length||a[nextIdx]!=Integer.MAX_VALUE)continue;
                    a[nextIdx]=level+1;
                    q.add(nextIdx);
                }
            }
            level++;
        }
        P.print(a);
    }
}
