package com.wu.array.twosum;

import java.util.HashMap;

/**
 * LeetCode1-两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        //方式一
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int val = target - nums[i];
//            if (map.containsKey(val) && map.get(val) != i){
//               return new int[]{i,map.get(val)};
//            }
//        }
//       return null;
        //方式二：
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}