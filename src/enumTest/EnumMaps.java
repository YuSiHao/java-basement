package enumTest;

import java.util.EnumMap;
import java.util.Map;

public class EnumMaps {
	public static void main(String[] args){
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(AlarmPoints.KITCHEN, new Command() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("kitchen fire!");
			}
		});
		em.put(AlarmPoints.BATHROOM, new Command() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("Bathroom alert!");
			}
		});
		for(Map.Entry<AlarmPoints, Command> e : em.entrySet()){
			System.out.println(e.getKey()+":");
			e.getValue().action();
		}
	}
}
