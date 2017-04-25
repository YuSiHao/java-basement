package enumTest;

import java.util.EnumSet;

public class EnumSets {

	public static void main(String[] args) {//枚举的集合。能够增加，减少，并且很高效
		// TODO Auto-generated method stub
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.STAIR2));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		System.out.println(points);
		points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));//这之间的remove
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
				
	}

}
