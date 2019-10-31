package com.jdk_8.collectors;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollectors<V> implements Collector<V, Set<V>, Map<V,V>>{

	@Override
	public Supplier<Set<V>> supplier() {
		return HashSet::new;
	}

	@Override
	public BiConsumer<Set<V>, V> accumulator() {
		return Set::add;
	}

	@Override
	public BinaryOperator<Set<V>> combiner() {
		return (m1,m2) -> {
			m1.addAll(m2);
			return m1;
		};
	}

	@Override
	public Function<Set<V>, Map<V, V>> finisher() {
		System.out.println("OK");
		return (s)->{
			try {
				Field f = s.getClass().getDeclaredField("map");
				f.setAccessible(true);
				return (HashMap)f.get(s);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashSet<>(Arrays.asList("123", "234", "345", "456")).parallelStream().collect(new MyCollectors<>());
		System.out.println(map);
	}
}
