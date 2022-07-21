package com.study.Leetcode.medium;

public class LongestPalindromicSubstring {
    /**
     * Approach 2: Brute Force
     * time complexity is O(n^3).
     * Space complexity : O(1).
     */
    public String longestPalindrome(String s) {
        String result = "";
        for(int len=s.length();len>0;len--){
            for(int i=0;i<=s.length()-len;i++){
                String str = s.substring(i, i+len);
                if (isPalindromic(str)) {
                    if(result.length() < str.length()){
                        result = str;
                    }
                }
            }
        }
        return result;
    }
    public boolean isPalindromic(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1 -i)) return false;
        }
        return true;
    }
    public String longestPalindrome3(String s) {
        String result = "" + s.charAt(0);
        for (int startIdx = 0; startIdx < s.length(); startIdx++) {
            String temp = "" + s.charAt(startIdx);
            if (result.length() < temp.length()) {
                result = temp;
            }

            int i = startIdx-1; int j = startIdx + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                temp = s.charAt(i) + temp + s.charAt(j);
                i--;
                j++;
            }

            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        for (int startIdx = 0; startIdx < s.length() - 1; startIdx++) {
            String temp = "" + s.charAt(startIdx) + s.charAt(startIdx + 1);

            if (isPalindromic(temp)) {
                if (result.length() < temp.length()) {
                    result = temp;
                }
            }

            int i = startIdx - 1; int j = startIdx + 1 + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                temp = s.charAt(i) + temp + s.charAt(j);
                i--;
                j++;
            }
            if(isPalindromic(temp)) {
                if(result.length() < temp.length()) result = temp;
            }
        }
        return result;
    }
    public String longestPalindrome4(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
