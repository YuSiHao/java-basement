package Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//		Collections.sort(names, new Comparator<String>() {
//		    @Override
//		    public int compare(String a, String b) {
//		        return b.compareTo(a);
//		    }
//		});
//		Collections.sort(names, (String a, String b) -> {
//		    return b.compareTo(a);
//		});
		Collections.sort(names, (a, b) -> b.compareTo(a));//Java编译器可以自动推导出参数类型
		System.out.println(names);
	}

}
