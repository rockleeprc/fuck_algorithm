package com.leetcode._560;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        // 3
        System.out.println(subarraySum2(nums, k));

//        System.out.println(1 + (-1));
//        System.out.println((-1) + 1);
//        System.out.println(1 + (-1) + 0);
    }

    /**
     * 前缀和+hash表 O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // 哈希表，记录前缀和及其出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化前缀和为0的情况出现1次
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            // 如果sum - k存在于哈希表中，说明存在和为k的子数组
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新哈希表中sum的出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * 暴力 O(n^2)
     * @param nums
     * @param k
     * @return
     */
    private static int subarraySum1(int[] nums, int k) {
        int hitCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, subHitCount = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    subHitCount++;
            }
            hitCount += subHitCount;
        }
        return hitCount;
    }


}
