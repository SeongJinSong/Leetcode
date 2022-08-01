package com.study.inflearn.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if(s1.length()!=s2.length()){
            System.out.println("NO");
            return;
        }
        char[] carr1 = s1.toCharArray();
        char[] carr2 = s2.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : carr1) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        String ans = "YES";
        for (char c : carr2) {
            if (hm.get(c) == null || hm.get(c) == 0) {
                ans = "NO";
                break;
            }
            hm.put(c, hm.get(c) - 1);
        }
        System.out.println(ans);
    }
}
