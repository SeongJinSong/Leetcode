package com.study.Leetcode.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    void lengthOfLongestSubstring(){
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(obj.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(obj.lengthOfLongestSubstring("bbbb"), 1);
        assertEquals(obj.lengthOfLongestSubstring("pwwkew"), 3);
        assertEquals(obj.lengthOfLongestSubstring(" "), 1);
        assertEquals(obj.lengthOfLongestSubstring("au"), 2);
        assertEquals(obj.lengthOfLongestSubstring("jbpnbwwd"), 4);
    }
}