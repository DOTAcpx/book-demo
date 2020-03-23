package com.algorithm;

import com.leecode.algorithm._945.MinIncrementForUnique;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {1,5,4,3,2,9,8};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr){
        qs(arr, 0, arr.length-1);
    }

    public void qs(int[] arr, int index, int end){
        int i=index,j=end;
        if(i<j){
            int num = arr[i];
            while(i != j){
                while(j>i && arr[j] > num){
                    j--;
                }
                if(i<j){
                    /*arr[i]已经保存在num中，可将后面的数填入*/
                    arr[i] = arr[j];
                    i++;
                }
                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
                while(i<j && arr[i] <= num){
                    i++;
                }
                if(i<j){
                    /*arr[j]已保存在arr[i]中，可将前面的值填入*/
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = num;
            qs(arr, index, i-1);
            qs(arr, j+1, end);
        }
    }
}
