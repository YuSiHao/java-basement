package fileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;

public class OSExecute {
	public static void command(String command){
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();//创建一个进程，ProcessBuilder构造器要求
			//命令作为一个String对象序列而被传递，start()然后所产生的ProcessBuilder对象被启动
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));//BufferedReader是将InputStreamReader读到BufferedReader里，也就是缓存里，inputStreamReader为将字节流转化成字符形式
			String s;
			while((s = results.readLine())!= null)
				System.out.println(s);
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s = errors.readLine())!= null)
				System.err.println(s);
				err = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(!command.startsWith("CMD/C"))
				command("CMD/C"+command);
			else 
				throw new RuntimeException(e);//传入之前的e是找到最早发生异常的点
		}
		if(err)
			throw new OSExecuteException("Errors executing"+command);
	}
}
