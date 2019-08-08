package com.book.book_18._011;

import java.io.*;
import java.lang.reflect.Constructor;

public class Test27 implements Serializable{
	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_011\\test27.txt";
	
	public static void main(String[] args) throws Exception {
		Constructor<Test27> c = Test27.class.getConstructor(String.class, int.class, double.class, double.class);
		Test27 test = c.newInstance("张三", 15, 300.50, 1.65);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(test);
		out.close();
		System.out.println(test);
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		Test27 t = (Test27)in.readObject();
		in.close();
		System.out.println(t);
	}

	private void writeObject(java.io.ObjectOutputStream out)
	    throws IOException {
		out.defaultWriteObject();
		out.writeDouble(banlace);
		out.writeDouble(height);
	}

	private void readObject(java.io.ObjectInputStream in)
	    throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		this.banlace = in.readDouble();
		this.height = in.readDouble();
	}
	
	private static final long serialVersionUID = 2199150542572047658L;
	private String name;
	private int age;
	private transient double banlace;
	private transient double height;
	public Test27(String name, int age, double banlace, double height) {
		this.name = name;
		this.age = age;
		this.banlace = banlace;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Test27 [name=" + name + ", age=" + age + ", banlace=" + banlace + ", height=" + height + "]";
	}
	
}
