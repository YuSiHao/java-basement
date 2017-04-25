package manageCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListSortSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>(Utilites.list);
		System.out.println("nowlist:"+list);
		list.addAll(Utilites.list);
		System.out.println("addalllist:"+list);
		Collections.shuffle(list, new Random(47));
		System.out.println("shuffle:"+list);
		ListIterator<String> it = list.listIterator(8);
		while (it.hasNext()) {
			it.next();
			System.out.println("next:"+it.next());
			it.remove();
		}
		System.out.println("Trimmed:"+list);
		Collections.sort(list);
		System.out.println("sort:"+list);
		String key = list.get(7);
		int index = Collections.binarySearch(list, key);//find the location of key in list
		System.out.println("location of"+key+"is"+index+list.get(index));
		Collections.sort(list,String.CASE_INSENSITIVE_ORDER);//有大小写的排列
	}

}
