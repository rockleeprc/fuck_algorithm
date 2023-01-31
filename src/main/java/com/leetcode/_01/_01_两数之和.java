package com.leetcode._01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _01_两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // 根据target-nums[i]的值从map获取索引位置
                return new int[]{map.get(target - nums[i]), i};
            }
            // key=数组中的值 value=数组的索引
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
