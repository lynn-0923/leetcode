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
### LeetCode1-两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```java
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
```
### LeetCode15-三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]
```java
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                } else if (sum > 0){
                    right--;
                }
            }
        }
        return result;
    }
}
```
### LeetCode18-四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length = nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*定义指针j指向i+1*/
                int j = i + 1;
                /*定义指针h指向数组末尾*/
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
```
### LeetCode7-整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
```java
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
```
### LeetCode8-字符串转换整数 (atoi)
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：
本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:
输入: "42"
输出: 42

示例 2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例 3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例 4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
因此无法执行有效的转换。

示例 5:
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
因此返回 INT_MIN (−231) 。

1. 去掉前导空格
2.再是处理正负号
3.识别数字，注意越界情况。
   也就是说会在某一步 ans * 10 + digit > Integer.MAX_VALUE。
   *10 和 +digit 都有可能越界，那么只要把这些都移到右边去就可以了。
   ans > (Integer.MAX_VALUE - digit) / 10 就是越界。
```java
class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0;
        boolean neg = false;
        while (index < n && chars[index] == ' '){
            index++;
        }
        if (index == n) {
            return 0;
        }
        if (chars[index] == '-') {
            neg = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(chars[index])) {
            int digit = chars[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return neg ? -ans : ans;
    }
}
```
### LeetCode9-回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ans = 0;
        int num = x;
        while (x != 0){
          ans = ans * 10 + x % 10;
          x /= 10;
        }
        return ans == num;
    }
}
```
### LeetCode面试题 01.07. 旋转矩阵
给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```java
class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] m = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                m[j][row - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }
}
```