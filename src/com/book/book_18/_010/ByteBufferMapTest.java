package com.book.book_18._010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.TimeUnit;

public class ByteBufferMapTest {

	static String file = "C:\\Users\\Administrator.PC-20190505ELDM\\Desktop\\123.mp4";
	static String writeFile = "D:\\work\\book-demo\\src\\com\\book\\book_18\\_010\\byteBufferMap.mp4";
	static Long fileLength;
	static {
		fileLength = new File(file).length() + 20L;
	}
	
	public static void main(String[] args) {
		RunTestTime mapRun = new MapByteBuffer();
		mapRun.run();
		
	}
	
	
	public static interface RunTestTime {
		default void run() {
			long startTime = System.nanoTime();
			try {
				runTest();
				System.out.println("执行耗时 : " + TimeUnit.NANOSECONDS.toSeconds((System.nanoTime() - startTime)) + " 秒");
			} catch (IOException e) {
				System.out.println("执行出错");
			}
		}
		void runTest() throws IOException;
	}

	public static class MapByteBuffer implements RunTestTime{
		@Override
		public void runTest() throws IOException{
			RandomAccessFile readAccessFile = new RandomAccessFile(file, "rw");
			RandomAccessFile writeAccessFile = new RandomAccessFile(writeFile, "rw");
			
			try {
				MappedByteBuffer readMap = readAccessFile.getChannel().map(MapMode.READ_ONLY, 0, fileLength);
				MappedByteBuffer writeMap = writeAccessFile.getChannel().map(MapMode.READ_WRITE, 0, fileLength);
				while(readMap.hasRemaining())
					writeMap.put(readMap.get());
				writeMap.flip();
			} finally {
				readAccessFile.close();
				writeAccessFile.close();
			}
		}
	}
}
