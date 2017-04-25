package enumTest;

import java.util.Random;

public class Enums {
	private static Random rand = new Random();
	public static <T extends Enum<T>> T Random(Class<T> ec){
		return random(ec.getEnumConstants());//利用Class对象得到enum实例的数组
	}
	public static <T> T random(T[] values){
		return values[rand.nextInt(values.length)];
	}
}
