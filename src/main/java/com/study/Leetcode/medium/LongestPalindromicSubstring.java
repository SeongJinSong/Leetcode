package com.study.Leetcode.medium;

public class LongestPalindromicSubstring {
    /**
     * Approach 2: Brute Force
     * time complexity is O(n^3).
     * Space complexity : O(1)O.
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
    public String longestPalindrome2(String s) {
        if(s.length()==1)return s;
        int l=0 ,r = 0;
        int[][] d = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(i==j){
                    d[i][j]=1;
                    continue;
                }
                if (j - i == 2 && s.charAt(i) == s.charAt(j) && s.charAt(i) == s.charAt(i + 1)) {
                    d[i][j]=1;
                    l=i; r=j+1;
                    continue;
                }
                if(i>1&&j<s.length()-2&&d[i][j]==1&&s.charAt(i-1)==s.charAt(j+1)){
                    d[i-1][j+1]=1;
                    if (r - l < (j + 1) - (i - 1)) {
                        l = i-1; r = j+1;
                    }
                    continue;
                }

                if(i+1==j&&s.charAt(i)==s.charAt(j)){
                    d[i][j]=1;
                    if (r - l < 1) {
                        l = i; r = j+1;
                    }
                    continue;
                }

                String str = s.substring(i, j);
                if (isPalindromic(str)) {
                    d[i][j]=1;
                    if (r - l < j - i) {
                        l = i; r = j;
                    }
                }
            }
        }
        return s.substring(l, r);
    }
}
