package mytemplates;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TestFreeMarket {
	private static String template = "C:/workPlace/forEclipse/Freemarker/src/mytemplates/";
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		 //1.读取freemarker配置文件
		Configuration conf = new Configuration();
		conf.setDirectoryForTemplateLoading(new File(template));
		 //2.读取模板
		Template t1 = conf.getTemplate("test.ftl");
		Map map = new HashMap();
		map.put("user", "doris1");
		map.put("rand", new Random().nextInt(100));
		 //4.写出到控制台
		Writer out = new OutputStreamWriter(System.out);
		t1.process(map, out);//执行模板，然后用map里面的值，out为system.out
		out.flush();
		out.close();
	}

}
