package com.leecode.algorithm._056;

import com.leecode.algorithm._206.ReverseList;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 ){
            return intervals;
        }
        int oldLength = intervals.length;
        for (int i = 0; i < oldLength; i++) {
            intervals = gen(intervals);
        }
        return intervals;
    }

    public int[][] gen(int[][] intervals){
        if(intervals.length == 0 ){
            return intervals;
        }
        Node node = new Node(intervals[0][0], intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start > node.end){
                node = getNext(node, start, end);
            }else {
                if(node.start > start){
                    if(node.end <= end){
                        node.start = start;
                        node.end = end;
                    }else if(node.start <= end){
                        node.start=start;
                    }else {
                        setUpper(node, start, end);
                    }
                }else {
                    if(node.end <= end){
                        node.end=end;
                    }
                }
            }
        }
        int[][] newIntervals = new int[node.num][];
        for (int i = newIntervals.length-1; i > -1 ; i--) {
            newIntervals[i] = new int[]{node.start, node.end};
            node = node.upper;
        }
        return newIntervals;
    }

    public Node getNext(Node node, int start, int end){
        node.next = new Node(start, end);
        node.next.num = node.num+1;
        node.next.upper = node;
        return node.next;
    }

    public void setUpper(Node node, int start, int end){
        Node upper = new Node(start, end);
        if(node.upper != null){
            node.upper.next = upper;
            upper.upper = node.upper;
        }
        upper.next = node;
        node.upper = upper;
        upper.num = node.num;
        node.num++;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
//        System.out.println("[[2,3],[4,5],[6,7],[8,9],[1,10]]".replace("[", "{").replace("]","}"));
        int[][] i = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        i = merge.merge(i);
        for (int[] is : i) {
            System.out.print(Arrays.toString(is)+",");
        }
    }
}

class Node{
    int num=1;
    int start;
    int end;
    Node next;
    Node upper;
    Node(int start, int end){
        this.start=start;
        this.end=end;
    }
}
