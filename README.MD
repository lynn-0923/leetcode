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
### LeetCode136-只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
```java
class Solution {
    public static int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
```
### LeetCode136-环形链表 II
```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public ListNode detectCycle(ListNode head) {
        //方式一:HashSet
//        HashSet<ListNode> set = new HashSet<>();
//        while (head !=null){
//            if (set.contains(head)){
//                return head;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return null;

        //方式二:快慢指针
        if (head == null || head.next == null) {
            return null;
        }
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //相遇点
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //二者相遇点
            if (fast == slow) {
                //定义新的点从head开始走
                meet = head;
                while (meet != slow) {
                    meet = meet.next;
                    slow = slow.next;
                }
                return meet;
            }
        }
        return null;
    }
}
```
### LeetCode645-错误的集合
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
导致集合丢失了一个整数并且有一个元素重复。

给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，
将它们以数组的形式返回。

示例 1:
输入: nums = [1,2,2,4]
输出: [2,3]

注意:
给定数组的长度范围是 [2, 10000]。
给定的数组是无序的。
```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int arr[] = new int[2];
        int newArr[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            newArr[nums[i]]++;
        }
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == 2) {
                arr[0] = i;
            }
            if (newArr[i] == 0) {
                arr[1] = i;
            }
        }
        return arr;
    }
}
```