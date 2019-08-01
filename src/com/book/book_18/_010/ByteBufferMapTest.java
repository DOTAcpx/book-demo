package com.book.book_18._010;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class ByteBufferMapTest {

	static String file = "C:\\Users\\Administrator.PC-20190505ELDM\\Desktop\\123.mp4";
	static String mapByteBuffer = "D:\\work\\book-demo\\src\\com\\book\\book_18\\_010\\mapByteBuffer.mp4";
	static String fileTest = "D:\\work\\book-demo\\src\\com\\book\\book_18\\_010\\fileTest.mp4";
	static String bufferByteWriteTest = "D:\\work\\book-demo\\src\\com\\book\\book_18\\_010\\bufferByteWriteTest.mp4";
	static Long fileLength;
	static {
		fileLength = new File(file).length() + 20L;
	}
	
	public static void main(String[] args) {
		RunTestTime mapRun = new MapByteBuffer();
		mapRun.run();
		RunTestTime bufferRun = new BufferByteWriteTest();
		bufferRun.run();
		RunTestTime fileRun = new FileTest();
		fileRun.run();
		
	}
	

	@FunctionalInterface
	public static interface RunTestTime {
		default void run() {
			long startTime = System.nanoTime();
			try {
				runTest();
				System.out.println("执行耗时 : " + (System.nanoTime() - startTime));
			} catch (IOException e) {
				System.out.println("执行出错");
			}
		}
		void runTest() throws IOException;
	}

	public static class MapByteBuffer implements RunTestTime {
		@Override
		public void runTest() throws IOException{
			RandomAccessFile readAccessFile = new RandomAccessFile(file, "rw");
			RandomAccessFile writeAccessFile = new RandomAccessFile(mapByteBuffer, "rw");
			
			try {
				MappedByteBuffer readMap = readAccessFile.getChannel().map(MapMode.READ_ONLY, 0, fileLength);
				MappedByteBuffer writeMap = writeAccessFile.getChannel().map(MapMode.READ_WRITE, 0, fileLength);
				while(readMap.hasRemaining())
					writeMap.put(readMap.get());
				writeMap.flip();
				readMap.clear();
				writeMap.clear();
			} finally {
				readAccessFile.close();
				writeAccessFile.close();
			}
		}
	}
	
	/**
	 * 使用该方法需注意盘符的格式,如果是NTFS的移动到FAT32会出现移动失败
	 */
	public static class FileTest implements RunTestTime {

		@Override
		public void runTest() throws IOException {
			File readFile = new File(file);
			File writeFile = new File(fileTest);
			readFile.renameTo(writeFile);
		}
		
	}
	
	public static class BufferByteWriteTest implements RunTestTime{

		@Override
		public void runTest() {
			BufferedInputStream inputStream = null;
			BufferedOutputStream outputStream = null;
			try {
				inputStream = new BufferedInputStream(new FileInputStream(file));
				outputStream = new BufferedOutputStream(new FileOutputStream(bufferByteWriteTest));
				int fileLength = (int) (ByteBufferMapTest.fileLength - 20);
				byte[] bytes = new byte[fileLength];
				inputStream.read(bytes);
				outputStream.write(bytes);
				outputStream.flush();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
