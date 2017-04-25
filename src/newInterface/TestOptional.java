package newInterface;

import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> optional = Optional.of("bam");//Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型,Optional 被定义为一个简单的容器，其值可能是null或者不是null,Java 8中，不推荐你返回null而是返回Optional
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("kong"));
		optional.ifPresent((s)->System.out.println(s.charAt(0)));
	}

}
