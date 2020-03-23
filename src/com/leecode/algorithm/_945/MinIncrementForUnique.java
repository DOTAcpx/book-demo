package com.leecode.algorithm._945;

import java.util.Arrays;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 *
 * 提示：
 *
 *
 * 	0 <= A.length <= 40000
 * 	0 <= A[i] < 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        if(A.length <= 1){
            return 0;
        }
        int max=0,min=A[0];
        int sum=0;
        for (int i : A) {
            if(i>max){
                max=i;
            }else if(min>i){
                min=i;
            }
        }

        int[] nums = new int[max-min+A.length];
        for (int i : A) {
            nums[i-min]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 1){
                nums[i+1] += nums[i]-1;
                sum+=nums[i]-1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,7};
        MinIncrementForUnique min = new MinIncrementForUnique();
        System.out.println(min.minIncrementForUnique(arr));
    }


}
