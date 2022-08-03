package com.study.inflearn.string;

import java.util.ArrayList;
import java.util.Scanner;

public class WordFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> sarr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sarr.add(sc.next());
        }
        for (String s : sarr) {
            StringBuilder sb = new StringBuilder(s).reverse();
            System.out.println(sb);
        }
        System.out.println("-----------");
        for (String s : sarr) {
            char[] carr = s.toCharArray();
            int lt=0, rt=s.length()-1;
            while (lt < rt) {
                char tmp = carr[lt];
                carr[lt] = carr[rt];
                carr[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(String.valueOf(carr));
        }

    }
}
