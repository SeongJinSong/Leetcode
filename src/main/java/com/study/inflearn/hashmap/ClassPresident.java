package com.study.inflearn.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        HashMap<String, Integer> hm = new HashMap<>();
        String ans = "";
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            String key = input.substring(i, i+1);
            int val = hm.getOrDefault(key, 0)+1;
            if(val>max){
                ans=key;
                max=val;
            }
            hm.put(key, val);
        }
        System.out.println(ans);
    }
}
