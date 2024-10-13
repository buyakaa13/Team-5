package Lab9.Prob7;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		//your stream pipeline here
		list.stream()
				.filter(x-> x.getSalary() > 100000 && Character.toLowerCase(x.getLastName().charAt(0)) > 'm')
				.map(x->x.getFirstName() + " " + x.getLastName())
				.sorted()
				.forEach(System.out::println);

		//LambdaLibrary way ------------
		List<String> employeeNames = LambdaLibrary.employeeName.apply(list, 100000, 'm');
		System.out.println(employeeNames);

	}

}
