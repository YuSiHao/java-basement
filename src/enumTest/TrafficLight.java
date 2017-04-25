package enumTest;

enum Signal{GREEN,YELLOW,RED}//switch内本身只能用整数值，而枚举实例天生就具备整数值的次序，并且通过ordinal()来获得次序，所以switch语句中可以用erum

public class TrafficLight {
	Signal color = Signal.RED;
	public void change(){ 
		switch(color){
			case RED: color = Signal.GREEN;
				break;
			case GREEN: color = Signal.YELLOW;
				break;
			case YELLOW: color = Signal.RED;
				break;		
		}
	}
	public String toString(){
		return "The traffic light is"+color;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficLight t = new TrafficLight();
		for(int i=0; i<7;i++){
			System.out.println(t);
			t.change();
		}
	}

}
