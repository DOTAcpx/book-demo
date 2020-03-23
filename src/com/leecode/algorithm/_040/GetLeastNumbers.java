package com.leecode.algorithm._040;

import java.util.Arrays;

/**
 * 面试题40
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }else if(k == arr.length){
            return arr;
        }
        partitionArray(arr, 0, arr.length-1, k);
        int[] returnNums = new int[k];
        System.arraycopy(arr, 0, returnNums, 0, k);
        return returnNums;
    }

    void partitionArray(int[] arr, int index, int end, int k){
        int partition = partition(arr, index, end);

        if(k == partition){
            return;
        }else if(k < partition){
            partitionArray(arr, index, partition-1, k);
        }else{
            partitionArray(arr, partition+1, end, k);
        }

    }

    //快速排序
    int partition(int[] arr, int index, int end){
        int i = index, j = end+1, num=arr[index];
        while(true){
            while (arr[++i] < num) {
                if (i == end) {
                    break;
                }
            }
            while (arr[--j] > num) {
                if (j == index) {
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(arr, i, j);
        }
        exchange(arr, index, j);
        return j;
    }
    void exchange(int[] arr, int i, int j){
        if(arr[i] != arr[j]){
            arr[i]^=arr[j];
            arr[j]^=arr[i];
            arr[i]^=arr[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,47,8,3,97,52,57,6,81,5,4,7,1,5,45,68,1,2,74,98,65};
        int k = 2;
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(arr, k)));
    }

    /**
     public int[] getLeastNumbers(int[] arr, int k) {
     if (k == 0) {
     return new int[0];
     } else if (arr.length <= k) {
     return arr;
     }

     // 原地不断划分数组
     partitionArray(arr, 0, arr.length - 1, k);

     // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
     int[] res = new int[k];
     for (int i = 0; i < k; i++) {
     res[i] = arr[i];
     }
     return res;
     }

     void partitionArray(int[] arr, int lo, int hi, int k) {
     // 做一次 partition 操作
     int m = partition(arr, lo, hi);
     // 此时数组前 m 个数，就是最小的 m 个数
     if (k == m) {
     // 正好找到最小的 k(m) 个数
     return;
     } else if (k < m) {
     // 最小的 k 个数一定在前 m 个数中，递归划分
     partitionArray(arr, lo, m-1, k);
     } else {
     // 在右侧数组中寻找最小的 k-m 个数
     partitionArray(arr, m+1, hi, k);
     }
     }

     // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
     // 代码参考 Sedgewick 的《算法4》
     int partition(int[] a, int lo, int hi) {
     int i = lo;
     int j = hi + 1;
     int v = a[lo];
     while (true) {
     while (a[++i] < v) {
     if (i == hi) {
     break;
     }
     }
     while (a[--j] > v) {
     if (j == lo) {
     break;
     }
     }

     if (i >= j) {
     break;
     }
     swap(a, i, j);
     }
     swap(a, lo, j);

     // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
     return j;
     }

     void swap(int[] a, int i, int j) {
     int temp = a[i];
     a[i] = a[j];
     a[j] = temp;
     }
     */
}
