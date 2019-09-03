package com.jdk_8.stream;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamListTest {
	public static void main(String[] args) {
//		Stream<String> stream = Stream.of("1", "2", "3", "4");
//		List<String> streamList = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
//		System.out.println(streamList);
		String[] strs = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String string = Stream.of(strs).collect(Collectors.joining(",")).toString();
		System.out.println(string);
		AppendTest toStringTest = (AppendTest) Proxy.newProxyInstance(ToStringTest.class.getClassLoader(), ToStringTest.class.getInterfaces(), new TestTime(new ToStringTest()));
		AppendTest toStringTest2 = (AppendTest) Proxy.newProxyInstance(ToStringTest.class.getClassLoader(), ToStringTest.class.getInterfaces(), new TestTime(new ToStringTest2()));
		AppendTest toStringTest3 = (AppendTest) Proxy.newProxyInstance(ToStringTest.class.getClassLoader(), ToStringTest.class.getInterfaces(), new TestTime(new ToStringTest3()));
		AppendTest append = (AppendTest) Proxy.newProxyInstance(Append.class.getClassLoader(), Append.class.getInterfaces(), new TestTime(new Append()));
		append.appendString(strs);
		toStringTest.appendString(strs);
		toStringTest2.appendString(strs);
		toStringTest3.appendString(strs);
		System.out.println("----------------------------");
		String[] strs2 = new String[100000];
		IntStream.range(0, 100000).forEach(i -> { strs2[i] = i + ""; });
		append.appendString(strs2);
		toStringTest3.appendString(strs2);
		toStringTest.appendString(strs2);
		toStringTest2.appendString(strs2);
	}
	
	
	
	
}

class TestTime implements InvocationHandler {
	Object proxy;
	public TestTime(Object proxy) {
		this.proxy = proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object refundObject = null;
		IntStream.range(0, 1000).forEach(i -> {
				try {
					method.invoke(this.proxy, args);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		);
		System.out.println();
		System.out.println(this.proxy.getClass().toString() + " " + (System.currentTimeMillis() - startTime) + " ss 耗时");
		return refundObject;
	}
}

interface AppendTest {
	String appendString(String[] str);
}

class ToStringTest implements AppendTest {
	static final char a1 = '(';
	static final char a3 = ')';
	@Override
	public String appendString(String[] strs) {
		String string = Arrays.toString(strs);
		String str = a1 + string.substring(1,string.length()-1) + a3;
//		String str = Arrays.asList(strs).toString().replace(a, a1).replace(a2, a3);
		return str;
	}
}
class ToStringTest2 implements AppendTest {
	static final char a = '[';
	static final char a1 = '(';
	static final char a2 = ']';
	static final char a3 = ')';
	@Override
	public String appendString(String[] strs) {
		String str = Arrays.toString(strs).replace(a, a1).replace(a2, a3);
		return str;
	}
}
class ToStringTest3 implements AppendTest {
	static final char a1 = '(';
	static final char a3 = ')';
	@Override
	public String appendString(String[] strs) {
		StringBuilder str = new StringBuilder(Arrays.toString(strs));
		str.setCharAt(0, a1);
		str.setCharAt(str.length()-1, a3);
		return str.toString();
	}
}
class Append implements AppendTest {
	static final char a = '(';
	static final CharSequence a1 = ",";
	static final char a2 = ')';
	@Override
	public String appendString(String[] strs) {
		String str = new StringBuilder().append(a).append(Stream.of(strs).collect(Collectors.joining(a1))).append(a2).toString();
		return str;
	}
	
}

