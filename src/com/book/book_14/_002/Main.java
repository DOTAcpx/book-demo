package com.book.book_14._002;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws Exception {
//		printClass(Class.forName("com.book.book_14._002.Test1"));
//		printClass(Test1.class);
//		printClass(Class.forName("com.book.book_14._002.Main"));
//		printClass(Main.class);
		int [] ints = {1,2,3};
//		printClass(ints.getClass());
		Integer i = ints[0];
//		printClass(i.getClass());
		printObj(i);
		printObj(ints);
	}
	
	public static void printClass(Class <?> clazz) throws Exception {
//		Object obj = clazz.newInstance();
		
		Method[] methods = clazz.getMethods();
		System.out.println(clazz.getTypeName());
		Iterator<Method> iterator = Arrays.asList(methods).iterator();
		while(iterator.hasNext()) {
			Method next = iterator.next();
			System.out.println(next);
		}
		System.out.println("---------------------------");
//		System.out.println(methods.getClass().getTypeName());
//		System.out.println(clazz);
	}
	
	public static void printObj(Object obj){
		if(obj instanceof Character) {
			System.out.println("是个字符");
		}else if(obj instanceof Integer) {
			System.out.println("是个int");
		}else if(obj instanceof Double) {
			System.out.println("是个double");
		}else if(obj instanceof Object) {
			System.out.println("是个对象");
		}
		
		if(obj instanceof Object) {
			System.out.println("是个对象啊");
		}
	}
}
