package Lambda;

class Person {
    String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public static void main(String[] args) {
    	PersonFactory<Person> personfactory = Person::new;//使用 Person::new 来获取Person类构造函数的引用，相当于通过构造函数实现了接口
    	Person person =  personfactory.create("jack", "lam");//Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数
    	System.out.println("Firstname:"+person.getFirstName());
    	
    }
}