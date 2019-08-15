package com.book.book_19.end;

import java.util.*;

public interface Shunt {
	class Scissors implements Shunt {// 剪刀
		@Override public String match(Shunt c) { return c.match(this); }
		@Override public String match(Scissors c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + DRAW; }
		@Override public String match(Stone c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + LOSE; }
		@Override public String match(Cloth c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + WIN; }
	}
	class Stone implements Shunt {// 石头
		@Override public String match(Shunt c) { return c.match(this); }
		@Override public String match(Scissors c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + WIN; }
		@Override public String match(Stone c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + DRAW; }
		@Override public String match(Cloth c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + LOSE; }
	}
	class Cloth implements Shunt {// 布
		@Override public String match(Shunt c) { return c.match(this); }
		@Override public String match(Scissors c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + LOSE; }
		@Override public String match(Stone c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + WIN; }
		@Override public String match(Cloth c) { return this.getClass().getSimpleName() + " vs " + c.getClass().getSimpleName() + " : " + DRAW; }
	}
	String WIN="Win", DRAW="Draw", LOSE="Lose";
	String match(Shunt c);
	String match(Cloth c);
	String match(Stone c);
	String match(Scissors c);
	
	public static void main(String[] args) {
		List<Shunt> list = new ArrayList<>();
		list.add(new Scissors());
		list.add(new Stone());
		list.add(new Cloth());
		Random ran = new Random(47);
		int listSize = list.size();
		for(int i = 0; i < 20; i++)
			System.out.println(list.get(ran.nextInt(listSize)).match(list.get(ran.nextInt(listSize))));
	}
}
