package com.t;

import java.util.HashMap;
import java.util.Map;

public class TTT {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
//        int[] nums = {1, 2, 3,3};
        int k = 0;
        // 3
        System.out.println(subarraySum(nums, k));
//        System.out.println(1 + (-1));
//        System.out.println((-1) + 1);
//        System.out.println(1 + (-1) + 0);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0的情况单独处理
        map.put(0,1);
        for (int num : nums) {
            sum += num;

            // 前缀和匹配，证明字数组出现
            if (map.containsKey(sum - k)) {
                // 对计数器累加
                count += map.get(sum - k);
            }

            // 更新前缀和的出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


}
