package com.study.Leetcode.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        int abcabcbb = test.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);

    }
    public int lengthOfLongestSubstring(String s){
        int max = 0;
        if(s.length()==1) return 1;
        for(int i=0;i<s.length();i++){
            HashSet hs = new HashSet();
            hs.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(hs.contains(s.charAt(j))){
                    if (hs.size() > max) {
                        max = hs.size();
                        break;
                    }
                    break;
                }
                hs.add(s.charAt(j));
                if (j == s.length() - 1) {
                    if (hs.size() > max) {
                        max = hs.size();
                    }
                    break;
                }
            }
        }
        return max;
    }
}
