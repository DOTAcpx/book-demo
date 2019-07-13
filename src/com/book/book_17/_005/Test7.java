package com.book.book_17._005;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

import com.book.book_17._002.Countries;

public class Test7 implements Test{
	
	public static void main(String[] args) {
		List<String> list = Countries.names();
		ArrayList<String> arrayList = new ArrayList<>(list);
		LinkedList<String> linkedList = new LinkedList<>(list);
		Test test = (Test) Proxy.newProxyInstance(Test7.class.getClassLoader(), Test7.class.getInterfaces(), new CountDuration(new Test7()));
		test.iteratorTest(linkedList,"linkedList");
		test.iteratorTest(arrayList,"arrayList");
	}
	
	public String toString() {
		return "123";
	}
	
	public String iteratorTest(List<String> list, String listName) {
		ListIterator<String> listIterator = list.listIterator();
		StringBuilder returnString = new StringBuilder();
		while(listIterator.hasNext()) {
			String previous = listIterator.next();
			listIterator.set("update : " + previous); 
			returnString.append(listName).append(" iteratorPreviousNext : ").append(previous);
		}
		return returnString.toString();
	}
	
	static Long time = 0L;
	static class CountDuration implements InvocationHandler {

		private Object proxy;
		public CountDuration(Object proxy) {
			this.proxy = proxy;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			state();
			Object object = method.invoke(this.proxy, args);
			end(method);
			return object;
		}
		
		public void state() {
			time = System.currentTimeMillis();
		}
		public void end(Method method) {
			System.out.println("执行方法 : " + method);
			System.out.println("耗时 : " + ((System.currentTimeMillis() - time)));
		}
		
		public String toString() {
			return "CountDuration";
		}
	}
}

@FunctionalInterface
interface Test {
	String iteratorTest(List<String> list, String listName);
	@Override
	String toString();
	@Override
	int hashCode();
}