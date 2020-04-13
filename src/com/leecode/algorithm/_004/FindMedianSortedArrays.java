package com.leecode.algorithm._004;

import java.util.Arrays;

/**
 * 
 * @author 早晨六点钟
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		int[] nums2 = {0,6};
		System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length == 0){
			if(nums2.length == 0){
				return 0;
			}
			return getMedian(nums2);
		}else if(nums2.length == 0){
			return getMedian(nums1);
		}

		int totalLength = nums1.length+nums2.length;
		int index1=0, index2=0, totalIndex=0;
		int index = totalLength/2;
		int[] nums = new int[index+1];
		while(index >= totalIndex){
			if(nums1[index1] > nums2[index2]){
				int num1=nums1[index1];
				while (index2<nums2.length && num1>nums2[index2] && index >= totalIndex){
					nums[totalIndex++]=nums2[index2++];
				}
				if(index2 >= nums2.length){
					while(totalIndex <= index){
						nums[totalIndex++]=nums1[index1++];
					}
					break;
				}
			}else if(nums1[index1] == nums2[index2]){
				if(index >= totalIndex){
					nums[totalIndex++]=nums1[index1++];
					if(index1 >= nums1.length){
						while(totalIndex <= index){
							nums[totalIndex++]=nums2[index2++];
						}
						break;
					}
				}
				if(index >= totalIndex){
					nums[totalIndex++]=nums2[index2++];
					if(index2 >= nums2.length){
						while(totalIndex <= index){
							nums[totalIndex++]=nums1[index1++];
						}
						break;
					}
				}
			}else {
				int num2=nums2[index2];
				while (index1<nums1.length && num2>nums1[index1] && index >= totalIndex){
					nums[totalIndex++]=nums1[index1++];
				}
				if(index1 >= nums1.length){
					while(totalIndex <= index){
						nums[totalIndex++]=nums2[index2++];
					}
					break;
				}
			}
		}
		double num=nums[index-1];
		if(totalLength%2 == 0){
			num = (num+nums[index])/2;
		}else {
			num=nums[index];
		}
		return num;
	}

	public double getMedian(int[] nums){
		int index = nums.length/2;
		if(nums.length%2 == 0){
			return ((double)(nums[index]+nums[index-1]))/2;
		}else {
			return nums[index];
		}
	}

//	/**
//	 *
//	 * @param nums1 [1,2]
//	 * @param nums2 [3,4]
//	 * 情况详细分析:
//	 * 1.num1头比num2头小,num1尾比num2头小 --> 可以不用排序比较,直接拼接判断取出中位数
//	 * 2.num1头比num2头小,num1尾比num2头大,num1尾比num2尾小,相交一段数据
//	 * 3.num1头比num2头小,num1尾比num2头大,num1尾比num2尾大,包含
//	 *
//	 * 4.num1头比num2头大,num1头比num2尾大 --> 可以不用排序比较,直接拼接判断取出中位数
//	 * 5.num1头比num2头大,num1头比num2尾小,num1尾比num2尾小
//	 * 6.num1头比num2头大,num1头比num2尾小,num1尾比num2尾大
//	 * @return
//	 */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    	int numMaxIndex1 = nums1.length - 1;
//    	int numMaxIndex2 = nums2.length - 1;
//    	init(nums1.length, nums2.length);
//    	//(1-3)的情况:
//    	if(nums1[0] < nums2[0]) {
//    		if(nums1[numMaxIndex1] < nums2[0]) {// 1的情况
//    			return void1(nums1, nums2);
//    		} else { //(2-3)的情况
//    			if(nums1[numMaxIndex1] < nums2[numMaxIndex2]) { // 2
//
//    			} else { // 3
//
//    			}
//    		}
//    	} else {// (4-6)的情况
//    		if(nums1[0] > nums2[numMaxIndex2]) {// 4的情况
//    			return void1(nums2, nums1);
//    		} else { //(5-6)的情况
//    			if(nums1[numMaxIndex1] < nums2[numMaxIndex2]) { // 5
//
//    			} else { // 6
//
//    			}
//    		}
//    	}
//    	return 0.0;
//    }
//
//    boolean isOne;
//    int middleLength;
//    /**
//     * 信息统一用isOne判断
//     * 长度是偶数有两个中位数,需要取齐相加的平均数
//     * 长度是奇数有一个中位数,直接返回索引middleLength的就可以
//     * @param length1
//     * @param length2
//     */
//    public void init(int length1, int length2) {
//    	int totalLength = length1 + length2;
//    	isOne = totalLength%2 == 1;
//		middleLength = totalLength / 2;
//    }
//
//	// 1.num1头比num2头小,num1尾比num2头小 --> 可以不用排序比较,直接拼接判断取出中位数
//    public double void1(int[] nums1, int[] nums2) {
//    	if(isOne) {
//    		if(nums1.length >= (middleLength+1)) {
//    			return nums1[middleLength];
//    		} else {
//    			return nums2[middleLength - nums1.length];
//    		}
//    	} else {
//    		int middleLength2 = middleLength - 1;
//    		if(nums1.length >= (middleLength2 + 1)) {
//    			if(nums1.length >= (middleLength + 1)) {
//					return (double)(nums1[middleLength]+nums1[middleLength2])/2;
//    			} else {
//    				return (double)(nums1[middleLength]+nums2[middleLength2-nums1.length])/2;
//    			}
//    		} else {
//				return (double)(nums2[middleLength-nums1.length]+nums2[middleLength2-nums1.length])/2;
//    		}
//    	}
//    }
//
//    /*  2.num1头比num2头小,num1尾比num2头大,num1尾比num2尾小,相交一段数据
//     * 判断num2头可以排序到num1的第几位
//     * 判断num1尾可以排序到num2的第几位
//     */
//    public double void2(int[] nums1, int[] nums2) {
//    	int start1 = startQuickSearch(nums2[0], nums1);
////    	int end2 = endQuickSearch(nums1[nums1.length-1], nums2);
//    	if(isOne) {
//    		if(middleLength > start1) {
//
//    		} else if(middleLength == start1){
//    			return nums2[0];
//    		} else {
//    			return nums1[middleLength];
//    		}
//    	} else {
//
//
//
//    	}
//    	return 0.0;
//    }
//
//    public int startQuickSearch(int x, int[] nums) {
//    	int length = nums.length;
//    	int index = 1;
//    	boolean isGreater = false;
//    	while((index*=2) < length && !(isGreater = nums[index] >= x));
//    	if(!isGreater) {
//    		while(nums[(index = (index/2 + length)/2)] <= x);
//    	}
//    	return index;
//    }
//
//    public int endQuickSearch(int x, int[] nums) {
//    	int index = nums.length;
//    	while(nums[index/=2] >= x);
//    	return index;
//    }
}
