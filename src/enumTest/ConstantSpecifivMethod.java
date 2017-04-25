package enumTest;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecifivMethod {
	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(ConstantSpecifivMethod csm : values())
			System.out.println(csm.getInfo());
	}

}
