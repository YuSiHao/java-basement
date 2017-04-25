package enumTest;

import java.util.Random;

public enum Input {//除开两个特殊的enum实体自己定义的amount方法会抛出异常，别的都会按照默认的给value赋值
	NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
	TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
	ABORT_TRANSATION{
		public int amount(){
			throw new RuntimeException("ABORT.AMOUNT()");
		}
	},
	STOP{
		public int amount(){
			throw new RuntimeException("SHUT_DOWN.AMOUNT()");
		}
	};
	int value;
	Input(int value){
		this.value = value;
	}
	Input() {
		// TODO Auto-generated constructor stub
	}
	int amount(){
		return value;
	}
	static Random rand = new Random(47);
	public static Input randomSelection(){
		return values()[rand.nextInt(values().length-1)];
	}
	
}
