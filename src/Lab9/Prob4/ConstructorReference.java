package Lab9.Prob4;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

class Human
{
	String name;
	int age;
	String gender;
	
	public Human(String name){
		this.name = name;
	}
	public Human(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Human(String name,int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

public class ConstructorReference {
public static void main(String args[]){
	Human[] list = { new Human("Joe",35,"Male"), new Human("Jane",45,"Female"), new Human("John",30,"Male")};
	
    // Query 1  : Print only Female candidates names
	Arrays.stream(list)
			.filter(x->x.gender.equals("Female"))
			.forEach(x-> System.out.println(x.name));

    /* Query 2 : Create an object for the Type of Human class by choosing suitable Interface for the three  constructors using ClassName::new. 
                 Then print the object status */
	Function<String, Human> lambda1 = Human::new;
	System.out.println(lambda1.apply("Anna"));
	BiFunction<String, Integer, Human> lambda2 = Human::new;
	System.out.println(lambda2.apply("Lisa", 23));
	TriFunction<String, Integer, String, Human> lambda3 = Human::new;
	System.out.println(lambda3.apply("Jennie", 31, "Female"));

	// Query 3 : Count the male candidates whose age is more than 30
	long count = Arrays.stream(list)
			.filter(x->x.gender.equals("Male") && x.age > 30)
			.count();
	System.out.println("Count: " + count);
    
   }



}
