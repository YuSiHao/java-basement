package mytemplates;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

public class FreemarketLocalTest {
	private static String template = "C:/workPlace/forEclipse/Freemarker/src/mytemplates/";
	public static void main(String[] args) throws IOException, TemplateException {
		// TODO Auto-generated method stub
		/* 一般在应用的整个生命周期中你仅需要执行一下代码一次*/  
        /* 创建一个合适的configuration */ 
		Configuration cfg = new Configuration();
		// 设置模板加载的方式 
		cfg.setDirectoryForTemplateLoading(new File(template));
		 // 设置模板共享变量，所有的模板都可以访问设置的共享变量  
		cfg.setSharedVariable("to_upper", new UpperCaseTransform());
		cfg.setSharedVariable("company","FooInc.");
		// 指定模板如何查看数据模型 
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		// 如果从多个位置加载模板，可采用以下方式  
        /** 
        FileTemplateLoader ftl1 = new FileTemplateLoader(new File("/tmp/templates")); 
        FileTemplateLoader ftl2 = new FileTemplateLoader(new File("/usr/data/templates")); 
        ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(),""); 
        TemplateLoader[] loaders = new TemplateLoader[] { ftl1, ftl2,ctl }; 
        MultiTemplateLoader mtl = new MultiTemplateLoader(loaders); 
        cfg.setTemplateLoader(mtl);**/  
		 /* 而以下代码你通常会在一个应用生命周期中执行多次*/  
        /*获取或创建一个模版*/  
		Template temp = cfg.getTemplate("freemarkerLocal.ftl");
		
		/*创建一个数据模型Create a data model */ 
		Map root = new HashMap();
		root.put("user", "Big Joe");
		Map latest = new HashMap();
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		root.put("latestProduct", latest);
		// 方法变量，indexOf为自己定义的方法变量  
		root.put("indexOf", new IndexOfMethod());
		
		 // 转换器变量  
        root.put("upperCase", new UpperCaseTransform()); 
		
		Writer out = new OutputStreamWriter(System.out);
		 temp.process(root, out);  
	        out.flush();  
	}

}
