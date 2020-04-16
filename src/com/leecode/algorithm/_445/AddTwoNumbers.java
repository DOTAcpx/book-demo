package com.leecode.algorithm._445;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while(l1 != null){
            s1.append(l1.val);
            l1=l1.next;
        }
        while(l2 != null){
            s2.append(l2.val);
            l2=l2.next;
        }
        char[] cs = new BigInteger(s1.toString()).add(new BigInteger(s2.toString())).toString().toCharArray();
        ListNode list = new ListNode(cs[0]-48);
        ListNode root = list;
        for (int i = 1; i < cs.length; i++) {
            list.next = new ListNode(cs[i]-48);
            list=list.next;
        }
        return root;
    }

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode l1 = add.getListNode(7, 2, 4, 3);
        ListNode l2 = add.getListNode(5, 6, 4);
        System.out.println(add.addTwoNumbers(l1, l2));
    }

    public ListNode getListNode(int... val){
        ListNode list = new ListNode(val[0]);
        ListNode root = list;
        for (int i = 1; i < val.length; i++) {
            list.next = new ListNode(val[i]);
            list=list.next;
        }
        return root;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val+","+next;
    }
}
