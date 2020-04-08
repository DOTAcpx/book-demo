package com.leecode.algorithm._289;

import java.util.Arrays;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 *
 * 	如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 	如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 	如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 	如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 *
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 *
 *
 * 进阶：
 *
 *
 * 	你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 	本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] tempNums = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            int[] bs = board[i];
            int[] temp = new int[bs.length];
            tempNums[i] = temp;
            for (int j = 0; j < bs.length; j++) {
                temp[j]=getNum(board, i, j);
            }
        }

        for (int i = 0; i < tempNums.length; i++) {
            int[] temp = tempNums[i];
            for (int j = 0; j < temp.length; j++) {
                if(temp[j] == 3){
                    board[i][j]=1;
                }else if(temp[j] != 2){
                    board[i][j]=0;
                }
            }
        }

    }

    /**
     *
     * @param board
     * @param i1 长
     * @param i2 宽
     * @return
     */
    public int getNum(int[][] board, int i1, int i2){
        int num=0;
        if(i1 != 0){
            num+=board[i1-1][i2];
            if(i2 != 0){
                num+=board[i1-1][i2-1];
            }
            if(i2+1 < board[0].length){
                num+=board[i1-1][i2+1];
            }
        }
        if(i2 != 0){
            num+=board[i1][i2-1];
            if(i1+1 < board.length){
                num+=board[i1+1][i2-1];
            }
        }
        if(i1+1 < board.length){
            num+=board[i1+1][i2];
            if(i2+1 < board[0].length){
                num+=board[i1+1][i2+1];
            }
        }
        if(i2+1 < board[0].length){
            num+=board[i1][i2+1];
        }
        return num;
    }

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        int[][] b = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        g.gameOfLife(b);
        for (int[] i : b) {
            System.out.println(Arrays.toString(i));
        }
    }
}
