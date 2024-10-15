package Lab10.Prob2;

import java.util.Objects;

public class Person {
	String name;
	public Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}

	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return name.equals(person.name);
	}

	public int hashCode () {
		return Objects.hash(name);
	}
}
