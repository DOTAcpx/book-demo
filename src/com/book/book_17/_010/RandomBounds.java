package com.book.book_17._010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomBounds {
	static void usage() {
		System.out.println("Usage");
		System.out.println("\tRandomBounds lower");
		System.out.println("\tRandomBounds upper");
		System.exit(1);
	}
	
	public static void main(String[] args) {
//		usageTest(args);
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		System.out.println(list);
		Collections.rotate(list, 3);
		System.out.println(list);
		System.out.println("---------------------------------");
		List<Integer> list2 = new ArrayList<>();
		IntStream.range(0, 9).forEach(list2::add);
		Collections.swap(list2, 0, 8);
		Collections.copy(list2, list);
		System.out.println(list2);
	}
	
	 private static <T> void rotate1(List<T> list, int distance) {
	        int size = list.size();
	        if (size == 0)
	            return;
	        distance = distance % size;
	        if (distance < 0)
	            distance += size;
	        if (distance == 0)
	            return;

	        for (int cycleStart = 0, nMoved = 0; nMoved != size; cycleStart++) {
	            T displaced = list.get(cycleStart);
	            int i = cycleStart;
	            do {
	                i += distance;
	                if (i >= size)
	                    i -= size;
	                displaced = list.set(i, displaced);
	                nMoved ++;
	            } while (i != cycleStart);
	        }
	    }
	static void usageTest(String[] args) {
		if(args.length != 1) usage();
		else if(args[0].equals("lower")) 
			while(Math.random() != 0.0) 
				System.out.println("Produced 0.0!");
		else if(args[0].equals("upper")) 
			while(Math.random() != 1.0) 
				System.out.println("Produced 1.0!");
		else usage();
	}
	
}
