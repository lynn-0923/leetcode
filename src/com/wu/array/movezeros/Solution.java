package com.wu.array.movezeros;


import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode283-移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
class Solution {
    public void moveZeroes(int[] nums) {
        //一：遍历
        if (nums.length == 0) {
            return;
        }
//        int j = 0;
//        int temp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0){
//               nums[j] = nums[i];
//               j++;
//            }
//        }
//        for (int i = j; i < nums.length; i++) {
//            nums[i] = 0;
//        }
        //二：一次遍历,根据快速排序的思想，将不等于0的放置在0的左边，等于0的放在右边
        int temp = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}