package com.book.book_13._004;

public class Demo {

	static Demo demo = new Demo();
	public static void main(String[] args) {
//		long strStartTime = System.currentTimeMillis();
//		demo.str();
//		long strEndTime = System.currentTimeMillis();
//		print(strStartTime, strEndTime);

		long sbStartTime = System.currentTimeMillis();
		demo.sb();
		long sbEndTime = System.currentTimeMillis();
		print(sbStartTime, sbEndTime);
		
		long sbStartTime2 = System.currentTimeMillis();
		demo.sb2();
		long sbEndTime2 = System.currentTimeMillis();
		print(sbStartTime2, sbEndTime2);
		
	}
	
	public void str() {
		String str = "";
		for(int i =0;i<10000;i++) {
			str += i;
		}
	}

	public void sb() {
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<100000;i++) {
			sb.append(" " + i + " " + " ");
		}
	}
	
	public void sb2() {
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<100000;i++) {
			sb.append(" ");
			sb.append(i);
			sb.append(" ");
			sb.append(" ");
		}
	}
	
	public static void print(long startTime,long endTime) {
		System.out.println("startTime : "+startTime);
		System.out.println("endTime : "+endTime);
		System.out.println(endTime - startTime);
		System.out.println("-------------------------------------------");
	}
}
