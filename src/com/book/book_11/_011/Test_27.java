package com.book.book_11._011;

import java.util.*;

public class Test_27 {
	static Test_27 t = new Test_27();
	public <E> void command(E e) {
		System.out.println(e);
	}
	public <E> void offer(PriorityQueue<E> q,E o) {
		q.offer(o);
	}
	public <E> void poll(Queue<E> q) {
		while(q.peek() != null) {
			command(q.poll());
		}
	}
	public static void main(String[] args) {
		PriorityQueue <Test_27.Demo> q = new PriorityQueue<Test_27.Demo>();
		//第一个添加成功
		t.offer(q,t.new Demo());
		//但是第二次添加的时候失败,因为第一次添加没有其他元素对比,第二次添加,无法进行比较,就抛出异常
		try {
			t.offer(q,t.new Demo());
			//被强转成父类,由于父类没有实现Comparable<Object>方法,无法进行比较,也是报错
			t.offer(q, t.new Demo2("3",1));
			t.offer(q, t.new Demo2("1",3));
		} catch (Exception e) {
			e.printStackTrace();//cannot be cast to java.lang.Comparable 
		}

		//实现了Comparable<Object>接口,并且实现compareTo方法,能够进行比较,执行成功
		//注意 需要实现的是Comparable<Object> 只能为Object类型
		PriorityQueue <Test_27.Demo2> q2 = new PriorityQueue<Test_27.Demo2>();
		t.offer(q2, t.new Demo2("3",1));
		t.offer(q2, t.new Demo2("1",3));
		t.offer(q2, t.new Demo2("2",5));
		t.poll(q2);
	}
	class Demo{
		
	}
	//
	class Demo2 extends Demo implements Comparable<Object>{
		private String s;
		private int i;
		public Demo2(){
			
		}
		public Demo2(String s){
			this.s = s;
		}

		public Demo2(int i){
			this.i = i;
		}

		public Demo2(String s,int i){
			this.i = i;
			this.s = s;
		}
		@Override
		public int compareTo(Object o) {
			Demo2 d = (Demo2)o;
			return this.i-d.i;
		}
	}
}

