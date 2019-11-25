package com.book.book_18._011;

import java.io.*;

public class SerializableTest {
	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_011\\serializableTest.txt";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
//			Test test = new Test(true);
//			stream.writeObject(test);
//		}
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(fileName)))){
			Test t = (Test) inputStream.readObject();
			System.out.println(t);
		}
	}
	
	static class Test implements Serializable{
		private static final long serialVersionUID = 1L;
		public boolean a;
		public String b;
		public Test(boolean a) {
			this.a = a;
		}
		@Override public String toString() {
			return a + " : " + b;
		}
	}
}
