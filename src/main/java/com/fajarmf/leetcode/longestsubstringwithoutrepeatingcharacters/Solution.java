package com.fajarmf.leetcode.longestsubstringwithoutrepeatingcharacters;

public class Solution {
    public static void main(String[] args) {
        /*
        Given a string s, find the length of the longest substring without repeating characters.
        */
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // Explanation:
    // 1. Create a variable to store the result.
    // 2. Create a variable to store the start index.
    // 3. Create a variable to store the end index.
    // 4. Create an array to store the count of each character.
    // 5. Loop through the string.
    // 6. Increment the count of the character.
    // 7. While the count of the character is greater than 1, decrement the count of the character at the start index and increment the start index.
    // 8. Set the result to the maximum of the result and the end index minus the start index plus 1.
    // 9. Increment the end index.
    // 10. Return the result.
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        int end = 0;
        int[] charCount = new int[128];
        while (end < s.length()) {
            charCount[s.charAt(end)]++;
            while (charCount[s.charAt(end)] > 1) {
                charCount[s.charAt(start)]--;
                start++;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
}
