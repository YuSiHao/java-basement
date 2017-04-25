package newInterface;

public class TestFormula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formula formula = new Formula() {
			
			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return sqrt(a*100);
			}
		};
		formula.calculate(100);
		formula.sqrt(16);
	}

}
