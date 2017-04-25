package manageCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class FailFast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> c = new ArrayList<String>();
		Iterator<String> it = c.iterator();
		c.add("fuck");
		try {
			String s = it.next();//容器迭代中增加元素，快速报错异常
		} catch (ConcurrentModificationException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
