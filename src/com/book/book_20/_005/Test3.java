package com.book.book_20._005;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test3 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestObjectCreate { }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestObjectCleanup {}

    @Target(value = { ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestProperty {}

    public static class AtUnit {
        public static void main(String[] args) {
            ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        }
    }

}
