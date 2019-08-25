package com.jdk_8.stream.map;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo1 {
	
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(np("zhangsan", 5), np("wangwu", 15), np("lisi", 12), 
				np("zhangsan", 45), np("wangwu", 45), np("lisi", 9), np("wangwu", 45), 
				np("chenyi", 20), np("zhangsan", 45), np("chenyi", 10), np("chenyi", 50), 
				np("lisi", 6), np("lisi", 3), np("zhangsan", 45), np("wangwu", 45), 
				np("wangwu", 45), np("lisi", 15), np("chenyi", 30), np("zhangsan", 45));
		prineGroupNum(list);
	}

	public static <T> void prineGroupNum(List<Person> personList) {
		// 第一个参数表示作为map的key值,第二个为map容器的真实实例,第三个为value值的实现
		Map<String, Integer> map = personList.stream().collect(
				Collectors.groupingBy(Person::getName, HashMap::new, Collectors.summingInt(Person::getBalance)));
		map.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
	}

//	public static <T> void prineGroupNum(List<Person> personList) {
//		// 第一个参数表示作为map的key值,第二个为map容器的真实实例,第三个为value值的实现
//		HashMap<String, IntSummaryStatistics> map = personList.stream().collect(
//				Collectors.groupingBy(Person::getName, HashMap::new, 
//				// 第一个参数(supplier) 对应value值的类型和初始值
//				// 第二个参数(accumulator) 获取map中对应的值后进行计算
//				// 第三个参数(combiner) 觉得毫无用处
//				Collector.of(IntSummaryStatistics::new,
//						(newValue, obj) -> {
//							newValue.accept(obj.getBalance());
//						}, (k, v)->null)));
//		map.forEach((k, v) -> {
//			System.out.println(k + " : " + v);
//		});
//	}
	public static Person np(String name, Integer balance) {
		return new Person(name, balance);
	}
	
	
	public <E> void test(List<E> list) {
		Object[] array2 = list.toArray();
		E[] array = (E[]) array2;
	}
	
}

class Person {
	public Person(String name, Integer balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	String name;
	Integer balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
