package Lab10.Prob2;
import java.util.*;
import java.util.function.*;

public class Main {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Bill", "Joe", "Tom");
		boolean result = contains1(list, "Joel");
		System.out.println(result);

		// Remove the /* */ to test your code once you implemented the generic method.
		Set<Integer> set = new HashSet<>(Arrays.asList(1,3,4,5,6,2));
		result = containsTarget(set, 3);
		System.out.println(result);

		Queue<String> queue = new LinkedList<>(Arrays.asList("Bill", "Joe", "Tom"));
		result = containsTarget(queue, "BillSmith");
		System.out.println(result);

		List<Employee> elist = new ArrayList<>();
		elist.add(new Employee(1003, "Tom", 60000));
		elist.add(new Employee(1002, "Harry", 70000));
		elist.add(new Employee(1001, "Joe", 50000));
		Employee e = new Employee(1001, "Joe", 50000);
		result = containsTarget(elist, e);
		System.out.println(result);

		List<Person> plist = new ArrayList<>();
		plist.add(new Person("Tom"));
		plist.add(new Person("Tim"));
		plist.add(new Person("Tonny"));
		plist.add(new Person("Taylor"));
		Person p = new Person("Tom");

		result = containsTarget(plist, p);
		System.out.println(result);

		List<Account> alist = new ArrayList<>();
		alist.add(new Account(123,5000));
		alist.add(new Account(124,3000));
		alist.add(new Account(125,4000));
		alist.add(new Account(126,2000));
		Account a = new Account(120,5000);

		result = containsTarget(alist, a);
		System.out.println(result);

	}
	public static boolean contains1(List<String> list, String s) {
		//could return list.contains(s), but this does not generalize
		if(list == null && s == null) return false;
		for(String x: list) {
			if(x.equals(s)) return true;
		}
		return false;
	}
      /* Implement here the Generic method as per the requirement. Use the method name as containsTarget()*/

	public static <T> boolean containsTarget(Collection<T> list, T target) {
		if(list == null && target == null) return false;
		for(T x: list) {
			if(x.equals(target)) return true;
		}
		return false;
	}
}
