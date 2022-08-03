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
    }
}
