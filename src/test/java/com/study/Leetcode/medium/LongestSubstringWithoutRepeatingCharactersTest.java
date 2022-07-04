package com.study.Leetcode.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    void lengthOfLongestSubstring(){
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, obj.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, obj.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, obj.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, obj.lengthOfLongestSubstring(" "));
        assertEquals(2, obj.lengthOfLongestSubstring("au"));
        assertEquals(4, obj.lengthOfLongestSubstring("jbpnbwwd"));
    }
}