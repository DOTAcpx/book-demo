package com.leecode.algorithm._892;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 *
 *
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 *
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 *
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 *
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        int sum=0, nowNum, oldNum=0;
        int[] old;
        // 先算第一排的长度,因为第一排后面没有方块,所以不用考虑后面要减去多少
        int[] now = grid[0];
        for (int i = 0; i < now.length; oldNum=now[i++]) {
            // 如果该位置没有 直接跳过
            nowNum=now[i];
            if(nowNum == 0){
                continue;
            }

            sum+=getNum(oldNum, nowNum);
        }

        // 从第二排开始 需要考虑有没有方块跟第一排的靠一起的
        for (int i = 1; i < grid.length; i++) {
            old=now;
            now=grid[i];
            oldNum=0;
            for (int j = 0; j < now.length; j++, oldNum=nowNum) {
                nowNum=now[j];
                if(nowNum == 0){
                    continue;
                }
                sum+=getNum(oldNum, nowNum);

                if(old.length > j){
                    if(old[j] < nowNum) {
                        sum-=(old[j]*2);
                    }else {
                        sum-=(nowNum*2);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 上一个位置的方块数 与 现在的方块数做比较
     */
    public int getNum(int oldNum, int nowNum){
        if(oldNum > nowNum){
            return nowNum*2+2;
        }else {
            return (nowNum*4+2) - oldNum*2;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{3,2},{5,5}};
        System.out.println(new SurfaceArea().surfaceArea(grid));
    }
}
