package Lab8.Prob3;

import java.util.Objects;
import java.util.function.Predicate;

public class MyClass {
	int x;
	String y;

	public MyClass(int x, String y) {
		this.x = x;
		this.y = y;
	}

	// testing method to check the equality using Lambda and Method reference
	public void myMethod(MyClass cl) {
		// Implement
		System.out.println(this.equals(cl));

		//lambda implementation using functional reference
		Predicate<MyClass> myLambda = c -> c.equals(this);

		//method reference implementation
		Predicate<MyClass> myMethodCl = this::equals;

		System.out.println(myLambda.test(cl) + " lambda");
		System.out.println(myMethodCl.test(cl) + " method");
		
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != getClass())
			return false;
		MyClass mc = (MyClass) ob;
		return mc.x == x && mc.y.equals(y);
	}

	public static void main(String[] args) {
		MyClass myclass = new MyClass(1, "A");
		MyClass myclass1 = new MyClass(1, "B");
		myclass.myMethod(myclass); // print true
		myclass.myMethod(myclass1); // print false
	}
}