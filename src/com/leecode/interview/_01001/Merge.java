package com.leecode.interview._01001;

import java.util.Arrays;

public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        int ai = 0, bi = 0;
        int[] tempA = new int[m];
        System.arraycopy(A, 0, tempA, 0, m);
        int end = m+n;
        int start = 0;
        while(start != end){
            if(ai == m){
                A[start]=B[bi++];
            }else if(bi == n){
                A[start]=tempA[ai++];
            }else if(tempA[ai] > B[bi]){
                A[start]=B[bi];
                bi++;
            }else {
                A[start]=tempA[ai];
                ai++;
            }
            start++;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        int m = 3;
        int n = 3;
        Merge merge = new Merge();
        System.out.println(Arrays.toString(A));
        merge.merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }
}
