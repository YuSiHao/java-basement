package enumTest;

class Mail{
	enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
	enum Scannability{UNSCANNABLE,YES1,YES2,YES3,YES4}
	enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
	enum Address{INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
	enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4,OK5}
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;
	public String toString(){
		return "Mail"+id;
	}
}

public class PostOffice {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
