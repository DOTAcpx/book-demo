package com.leecode.algorithm._206;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode[] ns = new ListNode[1];
        reverse(head, ns);
        head.next=null;
        return ns[0];
    }

    public void reverse(ListNode node, ListNode[] ns){
        if(node.next != null){
            ListNode n = node;
            reverse(node.next, ns);
            n.next.next=n;
        }else {
            ns[0]=node;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode root = list;
        for (int i = 0; i < 10; i++) {
            root.next = new ListNode(i);
            root=root.next;
        }
        System.out.println(list);
        list = new ReverseList().reverseList(list);
        System.out.println(list);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val+"=>"+next;
    }
}
