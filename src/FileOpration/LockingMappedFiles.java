package FileOpration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import org.omg.Messaging.SyncScopeHelper;

public class LockingMappedFiles {//对映射文件的部分加锁
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	static final int LENGTH = 0x8FFFFFF;//128 MB
	static FileChannel fc;
	
	private static class LockAndModify extends Thread{
		private ByteBuffer buff;
		private int start,end;
		LockAndModify(ByteBuffer mbb,int start,int end){
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();//缓冲区，用于修改的slice()
			start();//就是在执行run方法
		}
		public void run(){
			try {
				FileLock fl = fc.lock(start,end,false);
				System.out.println("Locked:"+start+"to"+end);
				while(buff.position()<buff.limit()-1)
					buff.put((byte) (buff.get()+1));
				fl.release();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		fc = new RandomAccessFile(filePath, "rw").getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for(int i=0;i<LENGTH;i++)
			out.put((byte) 'x');
	}

}
