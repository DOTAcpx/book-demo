package com.book.book_20._005;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AtUnitExamplel {

    public static String methodOne(){
        return "this is One Method";
    }

    private int i = 0;
    private AtUnitExamplel a;
    public String methodTwo() {
        if(a == null){
            a = new AtUnitExamplel();
        }
        return "this is Two Method " + (a.i++);
    }

    public boolean equalsOneTest(){
        return methodOne().equals("this is One Method");
    }


    public static void main(String[] args) {
        Method m = AtUnitExamplel.class.getMethods()[0];
        System.out.println(m.getName() + " :　" + m.getModifiers());
        System.out.println(java.lang.reflect.Modifier.isPublic(m.getModifiers()));
    }
}
