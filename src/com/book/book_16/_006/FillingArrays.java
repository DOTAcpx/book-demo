package com.book.book_16._006;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FillingArrays{
	private static class TestComparator implements Comparator<String>{
		public int compare(String a1,String a2) {
			return a1.hashCode() - a2.hashCode();
		}
	}
	public static void main(String[] args) {
		String[] strs = { "ab", "哈哈", "cjasido", "asduw", "wndgns", "㐏", "南师大", "1452634", "按时", "我我", "界面设计" };
		System.out.println(Arrays.toString(strs));
		Arrays.sort(strs, new FillingArrays.TestComparator());
//		Arrays.sort(strs, (a, b) -> {
//			char[] as = a.toCharArray();
//			char[] bs = b.toCharArray();
//			int forNum = as.length > bs.length ? bs.length : as.length;
//			for (int i = 0; i < forNum; i++) {
//				int zero = (as[i] - bs[i]);
//				if (zero != 0) {
//					return zero;
//				}
//			}
//			return 0;
//		});
//		Arrays.sort(strs, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strs));
		int i = Arrays.binarySearch(strs, "哈哈",String.CASE_INSENSITIVE_ORDER);
		System.out.println(binarySearch0(strs, 0, strs.length, "哈哈"));
		System.out.println(i);
		// System.out.println(strs[i]);
	}

	private static int binarySearch0(Object[] a, int fromIndex, int toIndex, Object key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			@SuppressWarnings("rawtypes")
			Comparable midVal = (Comparable) a[mid];
			@SuppressWarnings("unchecked")
			int cmp = midVal.compareTo(key);

			if (cmp < 0)
				low = mid + 1;
			else if (cmp > 0)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static void testSystem() {
		Integer[] nights = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] tens = new Integer[10];
		Arrays.fill(tens, 10);
		System.arraycopy(nights, 3, tens, 7, 3);
		System.out.println(Arrays.toString(nights));
		System.out.println(Arrays.toString(tens));
	}

	public static void testRandom() {
		Random one = new Random(48);
		Random two = new Random(47);
		System.out.println(one.nextInt(25));
		System.out.println(two.nextInt(25));
		System.out.println("----------------------------");
		System.out.println(one.nextInt(25));
		System.out.println(two.nextInt(25));
		System.out.println("----------------------------");
		System.out.println(one.nextInt(25));
		System.out.println(two.nextInt(25));
	}

	public static void testArraysFill() {
		String[] str = new String[10];
		Arrays.fill(str, 2, 4, "wawa");
		System.out.println(Arrays.deepToString(str));
		System.out.println(Arrays.toString(str));
	}
}
