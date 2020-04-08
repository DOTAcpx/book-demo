package com.leecode.interview._00107;

import java.util.Arrays;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n2 = matrix.length/2;
        int l = matrix.length;
        for (int i = 0, start=0; i < n2; i++,start++) {
            l--;
            for (int n = start; n < l; n++) {
                int temp = matrix[start][n];// 0,0
                matrix[start][n] = matrix[l-n+i][start]; // end,0 -> 0,0
                matrix[l-n+i][start] = matrix[l][l-n+i]; // end,end -> end,0
                matrix[l][l-n+i] = matrix[n][l]; // 0,end -> end,end
                matrix[n][l] = temp; // 0,0 -> 0,end
            }
        }
    }

    public static void main(String[] args) {

//        String s = "[ 5, 1, 9,11],[ 2, 4, 8,10],[13, 3, 6, 7],[15,14,12,16]";
//        System.out.println(s.replace("[", "{").replace("]", "}"));

        int[][] m = {{ 5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        Rotate r = new Rotate();
        for (int[] is : m) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println("---------------------------------");
        r.rotate(m);
        System.out.println("---------------------------------");
        for (int[] is : m) {
            System.out.println(Arrays.toString(is));
        }
    }
}
