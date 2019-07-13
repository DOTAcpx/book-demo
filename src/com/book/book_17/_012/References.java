package com.book.book_17._012;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class References {
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();
	public static void checkQueue() {
		Reference<? extends VeryBig> inq = rq.poll();
//		if(inq != null)
//			System.out.println(inq + " --- " + inq.get());
		
	}
	
	public static void main(String[] args) {
		int size = 10;
		if(args.length > 0)
			size = new Integer(args[0]);
		LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
		IntStream.range(0, size).forEach(i -> {
			sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
			checkQueue();
		});

		LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
		IntStream.range(0, size).forEach(i -> {
			WeakReference<VeryBig> weakReference = new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq);
			System.out.println(weakReference.get());
			wa.add(weakReference);
			checkQueue();
		});

		SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
		WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));
		System.gc();

		LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
		IntStream.range(0, size).forEach(i -> {
			pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i), rq));
			checkQueue();
		});
		WeakReference<VeryBig> weakReference = wa.get(0);
		System.out.println(weakReference.get());
	}
	
}


class VeryBig {
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	private String ident;
	public VeryBig(String id) {
		ident = id;
	}
	public String toString() {
		return ident;
	}
	protected void finalize() {
		System.out.println("Finalizing " + ident);
	}
}