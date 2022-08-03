package com.study.inflearn.string;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LinkedHashSet<Character> hs = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(!hs.contains(c)) {
                hs.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb);
        System.out.println("-----------------");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.indexOf(s.charAt(i))) {
                sb2.append(s.charAt(i));
            }
        }
        System.out.println(sb2);
    }
}
