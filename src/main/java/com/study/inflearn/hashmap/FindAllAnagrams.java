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
        for (int i = 0; i < len-1; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = len - 1; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            if(isAnagram(hm, t))ans++;
            int lt = i-len+1;
            hm.put(s.charAt(lt), hm.get(s.charAt(lt)) - 1);
            if(hm.get(s.charAt(lt))==0) hm.remove(s.charAt(lt));
        }
        return ans;
    }

    private boolean isAnagram(HashMap<Character, Integer> hm, String t) {
        //자바는 call by value 이므로 참조값을 가리키는 주소값을 복사해서 파라미터로 넘겨준다.
        //새로운 객체로 new를 하면, 원본 hm을 가리치는 주소값이 새로운 객체를 가리키게 된다.
        hm = (HashMap<Character, Integer>)hm.clone();
        for (char c : t.toCharArray()) {
            if(hm.get(c)==null||hm.get(c)==0)return false;
            hm.put(c, hm.get(c)-1);
        }
        return true;
    }
}
