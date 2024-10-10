package Lab8.Prob3;

import java.util.function.BiFunction;

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
		System.out.println("Lambda way -------------------");
		BiFunction<MyClass, MyClass, Boolean> lambda = (x,y)->x.equals(y);
		System.out.println(lambda.apply(this, cl));

		System.out.println("Method reference way -----------");
		BiFunction<MyClass, MyClass, Boolean> lambda1 = MyClass::equals;
		System.out.println(lambda1.apply(this, cl));
		
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