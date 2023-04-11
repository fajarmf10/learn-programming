package com.fajarmf.leetcode.stringtointegeratoi;

public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("  -0012a42"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("9223372036854775808"));
        System.out.println(myAtoi("-9223372036854775809"));
    }

    // Explanation:
    // 1. Discard whitespaces in the beginning
    // 2. Check if the next character (if not exist, return 0) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    // 3. Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
    // 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    // 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    // 6. Return the integer as the final result.
    public static int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;
        int len = s.length();

        // 1. Discard whitespaces in the beginning
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check if the next character (if not exist, return 0) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
        if (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // 3. Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            // 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // 6. Return the integer as the final result.
        return result * sign;
    }
}
