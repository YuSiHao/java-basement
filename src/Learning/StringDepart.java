package Learning;

import java.util.StringTokenizer;

public class StringDepart {
	public static void main(String[] args) {

		String str = "This is String , split by StringTokenizer, created by mkyong";
		StringTokenizer st = new StringTokenizer(str);//分隔String的工具类
		System.out.println("nextToken:" + st.nextToken());
		System.out.println("---- Split by space ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("---- Split by comma ',' ------");
		StringTokenizer st2 = new StringTokenizer(str, ",");

		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
	}
}