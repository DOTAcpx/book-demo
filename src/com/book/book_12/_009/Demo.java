package com.book.book_12._009;

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}


abstract class Inning{
	public Inning() throws BaseballException{}
	public void event() throws BaseballException{}
	public abstract void atBat() throws Strike,Foul;
	public void walk() {}
}

class StormException extends Exception{};
class RainedOut extends StormException{};
class PopFoul extends Foul{};

interface Storm{
	public void event()throws RainedOut;
	public void rainHard()throws RainedOut;
}
public class Demo extends Inning implements Storm{
	public Demo()throws RainedOut,BaseballException{}
	public Demo(String s)throws Foul,BaseballException{}
	//子类跟父类有一样的方法时候,父类的该方法没有抛出异常时,子类抛出异常
	//将会导致在用多态new出的子类时,调用该方法是抛出异常还是不抛出好,会导致编译时的错误
//	public void walk() throws PopFoul {}
	//异常可以少抛出,但是不能比父类抛出不一样的异常
//	public void event()throws RainedOut{}
	@Override
	public void rainHard() throws RainedOut {}
	@Override
	public void atBat() throws Strike, Foul {}
	
	public void event() {}
	
	public static void main(String[] args) {
		try {
			Demo d = new Demo();
			d.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("BaseballException");
		} 
		
		try {
			Inning i = new Demo();
			i.atBat();
		} catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("RainedOut");
		} catch (BaseballException e) {
			System.out.println("BaseballException");
		}
	}
}
