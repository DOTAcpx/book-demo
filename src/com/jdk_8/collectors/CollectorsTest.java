package com.jdk_8.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsTest {
	static List<Person> list;
	static {
		list = Arrays.asList(new Person("一", 1), new Person("三", 3), new Person("二", 2));
	}
	
	public static void main(String[] args) {
		Optional<Person> optional = list.stream().collect(Collectors.minBy(Comparator.comparingInt(Person::getAge)));
		optional.ifPresent(System.out::println);
	}

	static class Person {
		private String name;private int age;
		public Person(String name, int age) { this.name = name;this.age = age; }
		public String toString() {
			return getClass().getName() + ":[ name : " + name + ", age : " + age + " ]";
		}
		public int getAge() { return age; } public String getName() { return name; }
	}
}
