package ioNew;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {// 性能比较,映射文件访问往往可以显著提升速度
	private static int numofInts = 4000000;
	private static int numofbuffInts = 200000;

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			try {
				System.out.println(name + ": ");
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f", duration / 1.0e9);// float保留两位有效数字
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] tests = { new Tester("Stream Write") {
		public void test() throws IOException {
			// 用BufferedOutputStream,防止每次实际读取时都进行是实际写操作，而是从缓冲区直接读
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File("C:/Project/javaProject/test/test.txt"))));
			for (int i = 0; i < numofInts; i++)
				dos.writeInt(i);
			dos.close();
		}
	}, new Tester("Mapped write") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile("C:/Project/javaProject/test/test.txt", "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
			for (int i = 0; i < numofInts; i++)
				ib.put(i);
			fc.close();
		}
	}, new Tester("Stream Read") {
		public void test() throws IOException {
			// 用BufferedOutputStream,防止每次实际读取时都进行是实际写操作，而是从缓冲区直接读
			DataInputStream dis = new DataInputStream(
					new BufferedInputStream(new FileInputStream(new File("C:/Project/javaProject/test/test.txt"))));
			for (int i = 0; i < numofInts; i++)
				dis.readInt();
			dis.close();
		}
	}, new Tester("Mapped Read") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile("C:/Project/javaProject/test/test.txt", "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
			while (ib.hasRemaining())
				ib.get();
			fc.close();
		}
	}, new Tester("Stream Read/Write") {
		public void test() throws IOException {
			RandomAccessFile raf = new RandomAccessFile(new File("C:/Project/javaProject/test/test.txt"), "rw");
			raf.writeInt(1);
			for (int i = 0; i < numofbuffInts; i++) {
				raf.seek(raf.length() - 4);// 从这个位置开始读，跳过seek位置之前的
				raf.writeInt(raf.readInt());
			}
			raf.close();
		}
	}, new Tester("Mapped Read/Write") {
		public void test() throws IOException {
			FileChannel fc = new RandomAccessFile("C:/Project/javaProject/test/test.txt", "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
			ib.put(0);
			for (int i = 1; i < numofbuffInts; i++)
				ib.put(ib.get(i - 1));
			fc.close();
		}
	} };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Tester test : tests)
			test.runTest();
	}

}
