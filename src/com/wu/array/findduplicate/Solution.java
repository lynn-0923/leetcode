package com.wu.array.findduplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode287-寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                return nums[i];
            }
        }
        return -1;
    }
}