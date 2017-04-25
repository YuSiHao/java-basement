package newInterface;

public interface Formula {
	double calculate(int a);
	
	default double sqrt(int a){//接口里已经可以有实现的放啊，但是要加上default，默认的方法不能被lambda表达式访问到
		return Math.sqrt(a);
	}
}
