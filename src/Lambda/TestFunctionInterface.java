package Lambda;

public class TestFunctionInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter<String,Integer> converter = (from)->Integer.valueOf(from);//将lambda表达式当作任意只包含一个抽象方法的接口类型,编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的
		Integer convertered = converter.convert("123");
		System.out.println(convertered);
		Converter<String, Integer> converter1 = Integer::valueOf;// :: 关键字来传递方法,函数接口
		Integer converted = converter1.convert("123");
		System.out.println(converted);   // 123
		final int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);//可以直接在lambda表达式中访问外层的局部变量,但是和匿名对象不同的是，这里的变量num可以不用声明为final,但是隐性的具有final的语义，所以最好加上final
		System.out.println(stringConverter.convert(2));    // 3
		
	}
}
