package zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;



public class GZIPcompress {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	private static final String filePath1 = "C:/Project/javaProject/test/test2.txt";
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(filePath1)));//创建压缩的输出流
		System.out.println("Writing File");
		int c;
		while((c = in.read())!=-1)//将读到的文件压缩后写到filepath1下
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading File");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(filePath1))));//通过解压缩的方式将压缩过的文件还原出来放在输入流里
		String s;
		while((s = in2.readLine())!=null)
		System.out.println(s);
	}
}
