package com.algorithm;

/**
 * 细胞分裂:一开始有一个细胞,后面一个小时分裂一个子细胞,细胞最长的存活时间为3小时
 */
public class CellDivision {

    public static void main(String[] args) {
        int[] nums = new int[maxH+1];
        add(0, nums);
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < maxH; i++) {
            System.out.println("第"+(i+1)+"个小时的数量:"+nums[i]);
        }
    }

    static int maxH = 100;
    static void add(int h, int[] nums) {
        // 第一小时
        if(h == 0){
            nums[h] = 1;
            // 3h以内
        } else if(h < 3) {
            nums[h] = nums[h-1] * 2;
            // 3h后
        } else {
            nums[h] = (nums[h-1] * 2 - nums[h -3]);
        }
        if(h == maxH){
        } else {
            add(++h, nums);
        }
    }
}
