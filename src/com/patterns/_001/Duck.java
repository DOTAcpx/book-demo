package com.patterns._001;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public Duck() {}
	public abstract void display();
	public void swim() {
		System.out.println("所有的鸭子都会浮起来，甚至是诱捕!");
	}
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack() {
		quackBehavior.quack();
	}

	/* 使用动态设置鸭子的行为*/
	public void setFlyBehavior(FlyBehavior fly) {
		flyBehavior = fly;
	}
	public void setQuackBehavior(QuackBehavior quack) {
		quackBehavior = quack;
	}
	/** 小型鸭子模拟器*/
	static class MinDuckSimulator{
		public static void main(String[] args) {
//			delegate();
			setter();
		}
		
		public static void delegate() {
			Duck duck = new MallardDuck();
			duck.display();
			duck.performFly();
			duck.performQuack();
		}
		
		/**
		 * 设置(setter)
		 * 使用动态设置鸭子的行为
		 */
		public static void setter() {
			Duck duck = new ModelDuck();
			// 先让他飞和叫看看
			duck.performFly();
			duck.performQuack();
			// 改造成火箭一样飞吧
			System.out.println("改造之后 ... ");
			duck.setFlyBehavior(new FlyRocketPowered());
			// 试试飞行
			duck.performFly();
			duck.performQuack();
		}
	}
}
/** 飞行 */
interface FlyBehavior {
	public void fly();
}
class FlyWithWings implements FlyBehavior {
	@Override public void fly() {
		System.out.println("高高的飞起来了!");
	}
}
class FlyNoWay implements FlyBehavior {
	@Override public void fly() {
		System.out.println("不会飞的东西!");
	}
}
class FlyRocketPowered implements FlyBehavior {
	@Override public void fly() {
		System.out.println("跟火箭一样飞行");
	}
}

/** 叫声 */
interface QuackBehavior {
	public void quack();
}
class Quack implements QuackBehavior {
	@Override public void quack() {
		System.out.println("呱呱叫!");
	}
}
class MuteQuack implements QuackBehavior {
	@Override public void quack() {
		System.out.println("<<无声...>>");
	}
}
class Squeak implements QuackBehavior {
	@Override public void quack() {
		System.out.println("吱吱叫!");
	}
}

/**
 * 委托(delegate)
 * 在构造器里面赋予鸭子的行为
 */
class MallardDuck extends Duck {
	@Override public void display() {
		System.out.println("绿色的头");
	}
	public MallardDuck() {
		super.flyBehavior = new FlyWithWings();
		super.quackBehavior = new Quack();
	}
}

class ModelDuck extends Duck {

	@Override
	public void display() {
		System.out.println("模板鸭子");
	}
	
	public ModelDuck() {
		super.flyBehavior = new FlyNoWay();
		super.quackBehavior = new MuteQuack();
	}
}
