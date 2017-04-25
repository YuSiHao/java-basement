package enumTest;

enum Search {HITHER,YON}

public class UpcastEnum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search[] vals = Search.values();
		Enum e = Search.HITHER;
		System.out.println(e);
		//e.values(); //No values() in Enum
		for(Enum en:e.getClass().getEnumConstants())//enum实例向上转型为Enum,values()就不能访问了,通过getEnumConstants()依然能通过class对象取得所有enum实例
			System.out.println(en);
 	}

}
