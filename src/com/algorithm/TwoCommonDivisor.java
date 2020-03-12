package com.algorithm;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwoCommonDivisor {
//    static int listSize = 20;
//    static String[] nums = new String[listSize];
//    static int listSize2 = listSize/4*3;
//    static int index = 0;
//    static int maxNum = 100000;
//    public static void main(String[] args) {
//        long startTime = System.nanoTime();
//        for(int i = 2, num1 = 0, num2 = 0; i < maxNum; i++) {
//            if(maxNum%i == 0) {
//                if(num1 == 0) {
//                    num1 = i;
//                    num2 = maxNum/i;
//                } else if(num2 != i){
//                    i = 1;
//                    maxNum--;
//                    num1 = num2 = 0;
//                    continue;
//                }
//            }
//            if(i + 1 == maxNum) {
//                if(num1 != 0){
//                    nums[index++] = num1 + "*" + num2 + "=" + maxNum;
//                    checkNums();
//                }
//                num1 = num2 = 0;
//                i = 1;
//                maxNum--;
//            }
//        }
//        String[] nums = new String[index];
//        for (int i = 0; i < index; i++) {
//            nums[i] = TwoCommonDivisor.nums[i];
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//
//    public static void checkNums() {
//        if(index == listSize2) {
//            listSize *= 2;
//            listSize2 = listSize/4*3;
//            String[] nums = new String[listSize];
//            for (int i = 0; i < index; i++) {
//                nums[i] = TwoCommonDivisor.nums[i];
//            }
//            TwoCommonDivisor.nums = nums;
//        }
//    }

    static void print(){
        String[] s = {"a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l"};

        int zq;
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("请输入年龄 : ");
            double age = sc.nextDouble();
            zq = (age%7 > 0 ? 0 : -1) + (int)age/7;
        }

        if(zq < s.length) System.out.println(s[zq]);
    }

    public static void main(String[] args) {
        print();
    }
}
