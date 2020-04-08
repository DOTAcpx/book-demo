package com.leecode.algorithm._042;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap {
    public int trap(int[] height) {
        int old=0;
        int maxRight=0, maxLeft=0;
        int num=0, max=0, index=0;
        for (int i = 0; i < height.length; i++) {
            if(max < height[i]){
                max=height[i];
                index=i;
            }
            num+=height[i];
        }
        for (int i = 0; i < index; i++) {
            old=Math.max(old, height[i]);
            maxRight+=old;
        }
        old=0;
        for (int i = height.length-1; i > index; i--) {
            old=Math.max(old, height[i]);
            maxLeft+=old;
        }
        return maxLeft+maxRight+max-num;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {4,2,3};
        System.out.println(trap.trap(height));
    }
}
