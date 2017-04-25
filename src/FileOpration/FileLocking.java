package FileOpration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;

public class FileLocking {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutputStream(filePath);
		FileLock fl = fos.getChannel().tryLock();
		if(fl !=null){
			System.out.println("Locked File");
			TimeUnit.MICROSECONDS.sleep(100);//让线程睡一会
			fl.release();
			System.out.println("Release Lock");
		}
		fos.close();
	}
}
