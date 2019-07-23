package com.book.book_18._009;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test22 {
	
	public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入指令");
//		String command = scanner.nextLine();
//		inputCommand(command);
//		scanner.close();
		inputCommand("ipconfig");
	}
	/**
	 * 根据命令行输入指令获取对应信息
	 * @param command
	 * @throws Exception
	 */
	public static void inputCommand(String command) throws Exception {
		Process process = new ProcessBuilder(command.split(" ")).start();
		//需要根据对应电脑的编码格式去获取信息,例如我电脑的编码格式是gbk 则需要用gbk作为第二个参数去读取信息
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
		try {
			String s;
			while((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}
		} finally {
			inputStream.close();
		}
	}
	
}
