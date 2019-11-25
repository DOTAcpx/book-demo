package com.book.book_18._011;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.*;

public class Test30 {
	static String fileName = System.getProperty("user.dir") + "/src/com/book/book_18/_011/Test30.txt";

	public static void main(String[] args) throws IOException, Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		for (NewZero zero : NewZero.values()) {
			Zero z = zero.getZero();
			z.setC(Zero.ONE);
		}
		writeZero(new One(), "one1", out);
		writeZero(new One(), "one2", out);
		writeZero(new Two(), "two1", out);
		writeZero(new Two(), "two2", out);
		writeZero(new Three(), "three1", out);
		writeZero(new Three(), "three2", out);
		Three.writeC(out);
		out.close();
		System.out.println();
		System.out.println(" --------------------------- ");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		ArrayList<Object> l = new ArrayList<>();
		Object o;
		try {
			while ((o = in.readObject()) != null) {
				l.add(o);
			}
		} catch (Exception e) {
		}
		Three.readC(in);
		System.out.println(l);
		in.close();
	}

	private static void writeZero(Zero zero, String name, ObjectOutputStream out) throws IOException {
		zero.setName(name);
		out.writeObject(zero);
		System.out.print(zero + "   ");
	}

	static abstract class Zero implements Serializable {
		private static final long serialVersionUID = 1L;
		public static final int ONE = 1, TWO = 2, THREE = 3;

		public abstract void setC(int c);

		public abstract int getC();

		public abstract String getName();

		public abstract void setName(String name);

		@Override
		public String toString() {
			return getName() + " : " + getC();
		}
		// @Override public String toString() { return super.toString() + " : " +
		// getName() + " AND " + getC();}
	}

	static class One extends Zero {
		private static final long serialVersionUID = 1L;
		private String name = "one";
		private static int c = ONE;

		@Override
		public void setC(int c) {
			One.c = c;
		}

		@Override
		public int getC() {
			return c;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		};

		@Override
		public String getName() {
			return name;
		}
	}

	static class Two extends Zero {
		private static final long serialVersionUID = 1L;
		private String name = "two";
		private static int c = TWO;

		@Override
		public void setC(int c) {
			Two.c = c;
		}

		@Override
		public int getC() {
			return c;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		};

		@Override
		public String getName() {
			return name;
		}
	}

	static class Three extends Zero {
		private static final long serialVersionUID = 1L;
		private String name = "three";
		private static int c = THREE;

		public static void readC(ObjectInputStream in) throws IOException {
			Three.c = in.readInt();
		}

		public static void writeC(ObjectOutputStream out) throws IOException {
			out.writeInt(Three.c);
		}

		@Override
		public void setC(int c) {
			Three.c = c;
		}

		@Override
		public int getC() {
			return c;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		};

		@Override
		public String getName() {
			return name;
		}
	}

	enum NewZero {
		ONE() {
			@Override
			Zero getZero() {
				return new One();
			}
		},
		TWO() {
			@Override
			Zero getZero() {
				return new Two();
			}
		},
		THREE() {
			@Override
			Zero getZero() {
				return new Three();
			}
		};
		NewZero() {
		}

		abstract Zero getZero();
	}

	// public static void main(String[] args) throws IOException, Exception {
	// IntStream ten = IntStream.range(0, 5);
	// ObjectOutputStream out = new ObjectOutputStream(new
	// FileOutputStream(fileName));
	// ten.forEach(i ->{
	// for (NewZero zero : NewZero.values()) {
	// Zero z = zero.getZero();
	// z.setC(Zero.ONE);
	// try {
	// out.writeObject(z);
	// System.out.print(z + ",");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// try {
	// Three.writeC(out);
	// } catch (IOException e) { }
	// out.close();
	// System.out.println();
	// System.out.println(" --------------------------- ");
	//
	//
	// ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
	// ArrayList<Object> l = new ArrayList<>();
	// Object o;
	// try {
	// while((o = in.readObject()) != null) {
	// l.add(o);
	// }
	// } catch (Exception e) { }
	// Three.readC(in);
	// System.out.println(l);
	// in.close();
	// }
}
