package com.fajarmf.leetcode.medianoftwosortedarrays;

public class Solution {
    public static void main(String[] args) {
        /*
        Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
        Follow up: The overall run time complexity should be O(log (m+n)).
        */
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] m, int[] n) {
        // If m > n, swap the two arrays and set m to be the length of the smaller array and n to be the length of the larger array.
        if (m.length > n.length) {
            int[] temp = m;
            m = n;
            n = temp;
        }

        // Set imin = 0, imax = m, and halflen = (m + n + 1) / 2.
        int imin = 0;
        int imax = m.length;
        int halflen = (m.length + n.length + 1) / 2;

        /*
        While imin <= imax:
            Set i = (imin + imax) / 2 and j = halflen - i.
            If i < m and nums2[j-1] > nums1[i], increment imin.
            Else if i > 0 and nums1[i-1] > nums2[j], decrement imax.
            Else, we have found the median:
                If m + n is odd, return max(nums1[i-1], nums2[j-1])
                Else, return (max(nums1[i-1], nums2[j-1]) + min(nums1[i], nums2[j])) / 2.0.
        */
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halflen - i;
            if (i < m.length && n[j-1] > m[i]) {
                imin = i + 1;
            } else if (i > 0 && m[i-1] > n[j]) {
                imax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = n[j-1];
                } else if (j == 0) {
                    maxLeft = m[i-1];
                } else {
                    maxLeft = Math.max(m[i-1], n[j-1]);
                }
                if ((m.length + n.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m.length) {
                    minRight = n[j];
                } else if (j == n.length) {
                    minRight = m[i];
                } else {
                    minRight = Math.min(m[i], n[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
