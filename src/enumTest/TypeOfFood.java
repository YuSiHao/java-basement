package enumTest;

import enumTest.Food.Appetizer;
import enumTest.Food.Coffee;
import enumTest.Food.Dessert;
import enumTest.Food.MainCourse;

public class TypeOfFood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food = Appetizer.SALAD;
		food = MainCourse.BURRITO;
		food = Dessert.CREME_CARAMEL;
		food = Coffee.CAPPUCCINO;
	}

}
