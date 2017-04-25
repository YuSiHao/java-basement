package enumTest;

public enum OverrideConstantSpwcific {
	NUT, BOLT,
	WASHER{
		void f(){
			System.out.print("Overridden method");//覆盖常量方法
		}
	};
	void f(){
		System.out.println("default behavior");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(OverrideConstantSpwcific osc : values()){
			System.out.println(osc+":");
			osc.f();
		}
	}

}
