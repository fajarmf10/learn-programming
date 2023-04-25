package com.fajarmf.codility.binarygap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution(1041));
//        assert solution.solution(9) == 2;
//        assert solution.solution(529) == 4;
//        assert solution.solution(20) == 1;
//        assert solution.solution(15) == 0;
//        assert solution.solution(32) == 0;
//        assert solution.mySolution(328) == 2;
//        assert solution.solution(1041) == 5;
//        assert solution.solution(2147483647) == 0;
//        assert solution.solution(561892) == 3;
//        assert solution.solution(1376796946) == 5;
//        assert solution.solution(51712) == 2;
//        assert solution.solution(1162) == 3;
//        assert solution.solution(10011) == 1;
        System.out.println(solution.solution(1));
        System.out.println(solution.solution(328));
        System.out.println(solution.solution(42));
        System.out.println(solution.solution(561892));
        System.out.println(solution.solution(1376796946));
        System.out.println(solution.solution(2147483647));
    }

    public int solution(int N) {
        if(N < 4) {
            return 0;
        }
        String binaryResult = Integer.toBinaryString(N);
        int highestBinaryGap = 0;
        int counter = 0;

        // Because we will have no 0 at the start of the binaryResult, so we can start from index 1
        for(int i=1; i<binaryResult.length(); i++) {
            if(binaryResult.charAt(i) == '0') {
                counter++;
            }
            if(binaryResult.charAt(i) == '1' && binaryResult.charAt(i-1) == '0') {
                if(counter > highestBinaryGap) highestBinaryGap = counter;
                counter=0;
            }
        }
        return highestBinaryGap;
    }
}