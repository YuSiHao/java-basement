package mytemplates;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.TemplateTransformModel;

public class UpperCaseTransform implements TemplateTransformModel{
	
	
	// 转换器接口方法，将会转换标签之间的内容，首先把标签之间的内容读取到Writer对象中，  
    // 再由Writer对象对其中的内容施行转换处理，转换后的内容会再次存储到Writer 中  
	public Writer getWriter(Writer out,Map args){
		return new UpperCaseWrite(out);
	}
	
	private class UpperCaseWrite extends Writer {
		private Writer out;
		
		UpperCaseWrite(Writer out) {
			this.out = out;
		}
		public void write(char[] cbuf,int off,int len) throws IOException{
			out.write(new String(cbuf, off, len).toUpperCase());
		}
		public void flush() throws IOException{
			out.flush();
		}
		// 不用调用out.close,到达结束标签close会自动被调用
		public void close(){
			
		}
	}
}
