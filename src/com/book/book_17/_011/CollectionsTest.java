package com.book.book_17._011;

import java.util.*;

public class CollectionsTest {
	public static void main(String[] args) {
//		Collections.swap(list, i, j);
	}

	public <T extends Object & Comparable<? super T>> void testMax(Collection<T> c) {
		Iterator<? extends T> i = c.iterator();
		T candidate = i.next();

		while (i.hasNext()) {
			T next = i.next();
			if (next.compareTo(candidate) > 0)
				candidate = next;
		}
		System.out.println(candidate);
	}

	public <T extends Object & Comparable<? super T>> void testMin(Collection<T> c) {
		Iterator<? extends T> i = c.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) < 0)
                candidate = next;
        }
        System.out.println(candidate);
	}

	public void testRotate(List<?> list, int distance) {
		Collections.rotate(list, distance);
		if (list instanceof RandomAccess || list.size() < 100)
            rotate1(list, distance);
	}

	private <T> void rotate1(List<T> list, int distance) {
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

}
