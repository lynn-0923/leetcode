package com.wu.array.detectcycle;

import java.util.HashSet;
import java.util.List;

/**
 * LeetCode136-环形链表 II
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


/**
 * @author wu
 */
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