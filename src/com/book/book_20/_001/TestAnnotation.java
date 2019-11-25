package com.book.book_20._001;

import java.lang.annotation.*;
import java.util.Arrays;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestAnnotation {

	int id();
	
}
