package com.leecode.interview._00062;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 *
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LastRemaining {

    //使用约瑟夫环解法
    public int lastRemaining(int n, int m) {
        int index=0;
        for (int i = 2; i <= n; i++) {
            index=(index+m)%i;
        }
        return index;
    }

    // 暴力解法,时间长而且没效率
//    public int lastRemaining(int n, int m) {
//        Node root = new Node(0);
//        Node next = root;
//        for (int i = 1; i < n; i++) {
//            next.next = new Node(i);
//            next.next.upper = next;
//            next = next.next;
//        }
//        next.next = root;
//        root.upper = next;
//        next = root;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                next = next.next;
//            }
//            next.next.upper = next.upper;
//            next.upper.next = next.next;
//            next = next.next;
//        }
//
//        return next.num;
//    }
//
//    static class Node{
//        Node next;
//        Node upper;
//        int num;
//        Node(int num){
//            this.num = num;
//        }
//        public String toString(){
//            return num+"";
//        }
//    }

    public static void main(String[] args) {
        LastRemaining l = new LastRemaining();
        for (int n = 2; n < 10; n++) {
            for (int m = 1; m < 50; m++) {
                System.out.println("n:" + n + " m:" + m + " = " + l.lastRemaining(n, m));
            }
        }
//        int n = 100000, m = 1000000;
//        System.out.println("n:" + n + " m:" + m + " = " + l.lastRemaining(n, m));
    }
}
