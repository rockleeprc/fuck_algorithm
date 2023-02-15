package com.leetcode._04;

public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3}, nums2 = {2};
//        int[] nums1 = new int[]{1, 2}, nums2 = {3, 4};
//        int[] nums1 = new int[]{0, 0}, nums2 = {0, 0};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) // 判断偶数
            return (left + right) / 2.0;
        else
            return right;
    }
}
