package com.study.Leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
    /** Approach 2: Sliding Window
     * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
     * Space complexity : O(min(m, n)). Same as the previous approach.
     * We need O(k) space for the sliding window, where k is the size of the Set.
     * The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
     */
    public int lengthOfLongestSubstring2(String s){
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    /** Approach 3: Sliding Window Optimized
     * Time complexity : O(n). Index j will iterate n times.
     * Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
     * Space complexity (Table): O(m)O(m). mm is the size of the charset.
     */
    public int lengthOfLongestSubstring3(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        //try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring4(String s){
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }
            res = Math.max(res, right - left + 1);
            chars[r] = right;
            right++;
        }
        return res;
    }
}
