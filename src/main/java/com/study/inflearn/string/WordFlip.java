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
    }
}
