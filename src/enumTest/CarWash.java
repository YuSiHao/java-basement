package enumTest;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle{
		UNDERBODY{
			void action(){
				System.out.println("Spraying the underbody");
			}
		},
		WHEELWASH{
			void action(){
				System.out.println("Washing the wheels");
			}
		},
		PREWASH{
			void action(){
				System.out.println("Looseing the dirt");
			}
		},
		BASIC{
			void action(){
				System.out.println("The basic wash");
			}
		},
		HOTWAX{
			void action(){
				System.out.println("Applying hot wax");
			}
		},
		RINSE{
			void action(){
				System.out.println("Rinsing");
			}
		},
		BLOWDRY{
			void action(){
				System.out.println("Blowing dry");
			}
		};
		abstract void action();//这个不能删，为了能让用常量相关的方法，类似于多态，如果只有一个常量方法唯一的方法可以不加，多态一定要加，不加会报错
	}
	EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);
	public void add(Cycle cycle){
		cycles.add(cycle);
	}
	public void washCar(){
		for(Cycle c : cycles)
			c.action();
	}
	public String toString(){
		return cycles.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarWash wash = new CarWash();
		System.out.println(wash);
		wash.washCar();
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.RINSE);
		wash.add(Cycle.HOTWAX);
	System.out.println(wash);
	wash.washCar();
	
	}

}
