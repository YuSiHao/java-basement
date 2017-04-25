package mytemplates;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateCodeTest {
	private static String template = "C:/workPlace/forEclipse/Freemarker/src/mytemplates/";
	public static void main(String[] args) throws IOException,TemplateException{
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		// 设置模板加载的方式 
		cfg.setDirectoryForTemplateLoading(new File(template));
		// 指定模板如何查看数据模型 
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		/* 获取模板文件 */ 
		Template template = cfg.getTemplate("codeModel.ftl");
		
		/* 模板数据 */  
		Map<String, Object> root = new HashMap<String,Object>();
		root.put("class", "order");
		Collection<Map<String, String>> properties  = new HashSet<Map<String, String>>();
		root.put("properties", properties);
		
		 /* 字段1 orderId */  
        Map<String, String> orderId = new HashMap<String, String>();  
        orderId.put("name", "orderId");  
        orderId.put("type", "Long");  
        properties.add(orderId);  
  
        /* 字段2 orderName */  
        Map<String, String> orderName = new HashMap<String, String>();  
        orderName.put("name", "orderName");  
        orderName.put("type", "String");  
        properties.add(orderName);  
  
        /* 字段3 money */  
        Map<String, String> money = new HashMap<String, String>();  
        money.put("name", "money");  
        money.put("type", "Double");  
        properties.add(money);  
		
        /* 生成输出到控制台 */  
        Writer out = new OutputStreamWriter(System.out);  
        template.process(root, out);  
        out.flush();  
        /* 生成输出到文件 */ 
        File fileDir = new File("C:/workPlace/forEclipse/Freemarker/generateCodeFile");
        // 指定生成输出的文件  
        File output = new File(fileDir + "/Order.java");
        Writer writer = new FileWriter(output);  
        template.process(root, writer);//把模板和数据结合起来写到文件里面
        writer.close(); 
	}

}
