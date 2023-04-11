package com.fajarmf.leetcode.longestpalindromicsubstring;

public class Solution {
    public static void main(String[] args) {
        /*
        Given a string s, return the longest palindromic substring in s.
        */
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    // Explanation:
    // 1. Create a variable to store the result.
    // 2. Create a variable to store the start index.
    // 3. Create a variable to store the end index.
    // 4. Loop through the string.
    // 5. Set the start index to the current index.
    // 6. Set the end index to the current index.
    // 7. While the end index is less than the length of the string and the character at the end index is equal to the character at the end index plus 1, increment the end index.
    // 8. While the start index is greater than or equal to 0 and the end index is less than the length of the string and the character at the start index is equal to the character at the end index, decrement the start index and increment the end index.
    // 9. If the end index minus the start index minus 1 is greater than the length of the result, set the result to the substring of the string from the start index plus 1 to the end index.
    // 10. Return the result.
    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (end < s.length() - 1 && s.charAt(end) == s.charAt(end + 1)) {
                end++;
            }
            while (start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            }
            if (end - start + 1 > result.length()) {
                result = s.substring(start, end + 1);
            }
        }
        return result;
    }
}
