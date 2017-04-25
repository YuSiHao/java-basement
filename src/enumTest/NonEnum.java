package enumTest;

public class NonEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<Integer> intClass = Integer.class;
		for(Object en: intClass.getEnumConstants())
			System.out.println(en);
	}

}
