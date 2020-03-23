package com.leecode.algorithm.test._05178;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 * 如果数组中不存在满足题意的整数，则返回 0 。
 *
 * 示例：
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 */
public class SumFourDivisors {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        int count=2;
        int half=0;
        int one=0, two=0;
        for (int num : nums) {
            half=num/2;
            for (int i = 2; i < half; i++) {
                if(num%i == 0 && i != two){
                    if(count==4){
                        count+=2;
                        break;
                    }
                    one=i;
                    two=num/i;
                    if(one==two){
                        break;
                    }
                    count+=2;
                }
            }
            if(count==4){
                sum=sum+1+num+one+two;
            }
            count=2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        System.out.println(new SumFourDivisors().sumFourDivisors(nums));
    }
}
