### LeetCode283-移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
```java
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
```
### LeetCode287-寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
示例 1:
    输入: [1,3,4,2,2]
    输出: 2
示例 2:
    输入: [3,1,3,4,2]
    输出: 3

说明：
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
```java
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
```