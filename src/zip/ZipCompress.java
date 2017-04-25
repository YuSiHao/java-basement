package zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipCompress {
	private static final String filePathZip = "C:/Project/javaProject/test/test3.zip";
	private static final String[] files = {"C:/Project/javaProject/test/test.txt","C:/Project/javaProject/test/test2.txt"};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileOutputStream f = new FileOutputStream(filePathZip);//直接新建出这个文件
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());//Checksum类来计算和校验文件的校验和的方法，
		//Checksum有两种类型，Adler32更快，CRC32慢但更加精确
		ZipOutputStream zos = new ZipOutputStream(csum);//压缩的方式写入
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		for(String file: files){
			System.out.print("Writing file"+file);
			BufferedReader in = new BufferedReader(new FileReader(file));
			zos.putNextEntry(new ZipEntry(file));//Zip文件下创建文件
			int c;
			while((c = in.read())!=-1)
				out.write(c);
			in.close();
			out.flush();//清空缓冲区,不然下一次写入会把前一个文件里的东西一起写入进去
		}
		out.close();
		System.out.println("Checksum:"+csum.getChecksum().getValue());
		System.out.println("read file");
			FileInputStream fi = new FileInputStream(filePathZip);
			CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
			ZipInputStream in2 = new ZipInputStream(csumi);
			BufferedInputStream bis = new BufferedInputStream(in2);
			ZipEntry ze;
			while((ze = in2.getNextEntry())!=null){
				System.out.print("Reading file"+ze);
				int x;
				while((x = bis.read())!=-1)
					System.out.write(x);//输出字符流，println输出字节流
			}
			System.out.println("Checksum:"+csumi.getChecksum().getValue());
			bis.close();
			ZipFile zf = new ZipFile(filePathZip);
			Enumeration e = zf.entries();
			while(e.hasMoreElements()){
				ZipEntry ze2 = (ZipEntry) e.nextElement();
				System.out.println("file:"+ze2);
			}
	}
}
