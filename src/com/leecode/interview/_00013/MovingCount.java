package com.leecode.interview._00013;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 *
 * 提示：
 *
 *
 * 	1 <= n,m <= 100
 * 	0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        int[][] nums=new int[n][m];
        return find(0, 0, k, nums);
    }

    public int find(int x, int y, int k, int[][] nums){
        if(nums[x][y] == 1){
            return 0;
        }else {
            nums[x][y]=1;
            if(addOne(x, y, k)){
                return 1+((x+1)<nums.length?find(x+1, y, k, nums):0)+((y+1)<nums[0].length?find(x, y+1, k, nums):0);
            }else {
                return 0;
            }
        }
    }

    public boolean addOne(int n, int m, int k){
        if(n==0){
            return (m%10+m/10%10+m/100) <= k;
        }else if(m==0){
            return (n%10+n/10%10+n/100) <= k;
        }
        return (n%10+n/10%10+n/100+m%10+m/10%10+m/100) <= k;
    }

    public static void main(String[] args) {
        int m = 16;
        int n = 8;
        int k = 4;
        System.out.println(new MovingCount().movingCount(m, n, k));
    }
}
