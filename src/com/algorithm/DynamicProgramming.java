package com.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 动态规划
 * @author Administrator
 *
 */
public class DynamicProgramming {

	
	public static void main(String[] args) {
//		int mining = mining(10, new int[][]{{500, 5}, {200, 3}, {300, 4}, {350, 3}, {400, 5}});
//		System.out.println(mining);
	}
	
	/**
	 * 爬楼梯
	 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。
	 * 要求用程序来求出一共有多少种走法。
	 */
	public static int stairs(int num) {
		if(num < 1) 
			return 0;
		if(num == 1) 
			return 1;
		if(num == 2) 
			return 2;
		int a = 1, b = 2, c = 0;
		for(int i = 2; i < num; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	/**
	 * 国王和金矿
	 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
	 * 参与挖矿工人的总数是10人。
	 * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
	 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
	 * @author Administrator
	 */
	static class Mining {
		/** 记录范围区间的最大值集合*/
		private static final List<Integer> SECTION_LIST = new LinkedList<>();
		private static final List<Integer> VALUE_LIST = new LinkedList<>();
		/**
		 * @param personNum 最高可工作人数
		 * @param goldMines 金矿和人数的二维数组,索引0放入金额,索引1放入消耗人数
		 */
		public static int run(int personNum, int[][] goldMines) {
			int[] distribution =  new int[personNum];
			return 0;
		}
	}
	
	
}
