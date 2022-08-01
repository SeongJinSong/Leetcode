package com.study.inflearn.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        FindAllAnagrams T = new FindAllAnagrams();
        System.out.println(T.solution(s, t));
    }

    private int solution(String s, String t) {
        int len = t.length();
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < len-1; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            hm2.put(t.charAt(i), hm2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = len - 1; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            if(hm.equals(hm2))ans++;
            int lt = i-len+1;
            hm.put(s.charAt(lt), hm.get(s.charAt(lt)) - 1);
            if(hm.get(s.charAt(lt))==0) hm.remove(s.charAt(lt));
        }
        return ans;
    }
}
