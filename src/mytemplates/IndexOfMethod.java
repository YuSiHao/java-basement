package mytemplates;

import java.util.List;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateTransformModel;

public class IndexOfMethod implements TemplateMethodModel{
	 public Object exec(List args) throws TemplateModelException{
		 if(args.size() != 2 ){
			 throw new TemplateModelException("Wrong arguments");
		 }
		 // 返回第一个字符串首次出现在第二个字符串的位置  
	        return new SimpleNumber(((String) args.get(1))  
	                                .indexOf((String) args.get(0)));  
	 }
}
