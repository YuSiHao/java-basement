package Steam;

public class Person {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private Integer age;
	
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getInfo() {
	    return name + " (" + age + ")";
	}
	
}