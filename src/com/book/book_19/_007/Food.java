package com.book.book_19._007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public interface Food {
	enum Appetizer implements Food {
		APP_A, APP_B, APP_C, APP_D;
	}
	enum MainCourse implements Food {
		MAIN_A, MAIN_B, MAIN_C, MAIN_D;
	}
	enum Coffee implements Food {
		COFFEE_A, COFFEE_B, COFFEE_C, COFFEE_D;
	}
	
	enum F {
		APP(Food.Appetizer.class), MAIN(Food.MainCourse.class), COFFEE(Food.Coffee.class);
		private Food[] fs;
		F(Class<? extends Food> f) {
			fs = f.getEnumConstants();
		}
		@Override public String toString() { return Arrays.toString(fs); }
	}
	
	public static void main(String[] args) {
		System.out.println(F.APP);
		F valueOf = Enum.valueOf(F.class, "APP");
		System.out.println(valueOf);
		EnumSet.allOf(F.class).forEach(System.out::println);;
	}
}
