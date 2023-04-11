package com.fajarmf.leetcode.romantoint;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MMMCMXCIX"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentSymbolValue = romanNumerals.get(s.charAt(i));
            int nextSymbolValue = (i < s.length() - 1) ? romanNumerals.get(s.charAt(i + 1)) : 0;

            if (nextSymbolValue > currentSymbolValue) {
                result -= currentSymbolValue;
            } else {
                result += currentSymbolValue;
            }
        }

        return result;
    }
}
