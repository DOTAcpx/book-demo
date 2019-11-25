package com.book.book_20._001;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class SqlTest {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Table {
		String name() default "";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface StrField {
		String name() default "";
		String value() default "";
		IDField fieldType() default @IDField;
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface IntField {
		String name() default "";
		int value() default -1;
		IDField fieldType() default @IDField;
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface IDField {
		boolean primary() default false;
		boolean auto() default false;
	}
	
	@Table
	class Account {
		@IntField int age;
		@StrField String name;
		@IntField(fieldType=@IDField(primary = true, auto = true)) int id;
	}
	
	public static void main(String[] args) {
		try {
			genSql(Account.class);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void genSql(Class<?> clazz) throws ParserConfigurationException, SAXException, IOException {
//		Table table = clazz.getDeclaredAnnotation(Table.class);
//		StringBuilder sql = new StringBuilder();
////		Document document = builder.parse(new File(System.getProperty("user.dir") + "/src/com/book/book_20/_001/sql.xml"));
//		if(table != null) {
//			String name = table.name();
//			if(name != null && !"".equals(name)) {
//				sql.append(" tableNmae : ").append(name);
//			} else {
//				String className = clazz.getSimpleName();
//				sql.append(" tableNmae : ").append(className.substring(0, 1).toLowerCase() + className.substring(1));
//			}
//			Field[] fields = clazz.getDeclaredFields();
//			for (Field field : fields) {
//				if(field.isAnnotationPresent(StrField.class)) {
//					StrField strField = field.getDeclaredAnnotation(StrField.class);
//					String n = strField.name();
//					sql.append(" \r\n varchar : ").append( n != null && !"".equals(n) ? n : field.getName());
//				} else if(field.isAnnotationPresent(IntField.class)) {
//					IntField intField = field.getDeclaredAnnotation(IntField.class);
//					String n = intField.name();
//					sql.append(" \r\n int : ").append( n != null && !"".equals(n) ? n : field.getName());
//				}
//			}
//		}
//		System.out.println(sql);
//		
//	}
//	public static void genSql(Class<?> clazz) throws ParserConfigurationException, SAXException, IOException {
//		Table table = clazz.getDeclaredAnnotation(Table.class);
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
//		Document document = builder.newDocument();
////		Document document = builder.parse(new File(System.getProperty("user.dir") + "/src/com/book/book_20/_001/sql.xml"));
//		if(table != null) {
//			String name = table.name();
//			Element element;
//			if(name != null && !"".equals(name)) {
//				element = document.createElement(name);
//			} else {
//				String className = clazz.getSimpleName();
//				element = document.createElement(className.substring(0, 1).toLowerCase() + className.substring(1));
//			}
//			Field[] fields = clazz.getDeclaredFields();
//			for (Field field : fields) {
//				if(field.isAnnotationPresent(StrField.class)) {
//					StrField strField = field.getDeclaredAnnotation(StrField.class);
//					String n = strField.name();
//					element.setAttribute("varchar", n != null && !"".equals(n) ? n : field.getName());
//				} else if(field.isAnnotationPresent(IntField.class)) {
//					IntField intField = field.getDeclaredAnnotation(IntField.class);
//					String n = intField.name();
//					element.setAttribute("int", n != null && !"".equals(n) ? n : field.getName());
//				}
//			}
//			System.out.println(element);
//		}
//		
//	}
	public static void genSql(Class<?> clazz) throws ParserConfigurationException, SAXException, IOException {
		Table table = clazz.getDeclaredAnnotation(Table.class);
//		new 
	}
}

class Test3 {
	public static void main(String[] args) {
	}
}


