package com.book.book_20._001;

import java.lang.reflect.Method;

public class AnnotationDemo {
	
	public static void main(String[] args) {
		for(Method m : AnnotationDemo.class.getMethods()) {
			System.out.print(m.getName() + " : ");
			TestAnnotation annotation = m.getAnnotation(TestAnnotation.class);
			if(annotation != null) {
				System.out.println(annotation.id());
			}
		};
	}
	
	@TestAnnotation(id = 0) 
	public void say() {
		System.err.println("-----");
	}
	
	
}

