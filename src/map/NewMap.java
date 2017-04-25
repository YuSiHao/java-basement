package map;

import java.util.HashMap;
import java.util.Map;

public class NewMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<>();
		for(int i=0;i<10;i++){
			map.putIfAbsent(i, "val"+i);
		}
		map.forEach((id,val)->System.out.println(val));
		map.computeIfPresent(3, (num,val)->val+num);
		System.out.println(map.get(3));
		map.computeIfPresent(9, (num,val)->null);
		System.out.println(map.containsKey(9));
		map.remove(3, "val3");
		System.out.println(map.get(3));             // val33
		map.remove(3, "val33");
		System.out.println(map.get(3));             // null
		map.merge(9, "val9", (value,newValue)->value.concat(newValue));
		System.out.println(map.get(9));
		map.merge(9, "concat", (value,newValue)->value.concat(newValue));
		System.out.println(map.get(9));
	}

}
