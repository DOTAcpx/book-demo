package com.book.book_11._007;

import java.util.*;

public class LinkedListDemo {
	
	public static LinkedListDemo DEMO = null;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		LinkedListDemo listDemo = null;
		LinkedList<Integer> list = listDemo.get();
		print(list);
		print("list.getFirst获取第一个数据,但不删除: " + list.getFirst());
		print("list.element()获取第一个数据,但不删除 : " + list.element());
		print("list.peek()获取第一个数据,但不删除" + list.peek());
		print("list.remove()删除第一个数据并且取出" + list.remove());
		print("list.removeFirst()删除第一个数据并且取出" + list.removeFirst());
		print("list.poll()删除第一个数据并且取出" + list.poll());
		print(list);
		list.addFirst(11);
		print("list.addFirst()从前面添加数据" + list);
		list.offer(12);
		print("list.offer()从后面添加数据" + list);
		
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	public static LinkedList<Integer> get() {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		return list;
	}
	
	
}
