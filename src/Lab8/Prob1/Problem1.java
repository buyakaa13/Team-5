package Lab8.Prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class Problem1 {

	public static void main(String[] args) {
		// To understand functions as First class citizen
		 List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		 // Task 1: Identify the suitable interface to read the input and print doubled
		 Function<Integer, Integer> lambda = x-> x+x;
		 changeDouble(numbers, lambda);// Output: 2 4 6 8 10
	
		 List<String> data = Arrays.asList("apple", "banana", "cherry");
	     //Task 2: Take input of String and transform into Upper case
		 Function<String, String> lambda1 = x-> x.toUpperCase();
		 transformStrings(data, lambda1);
		 
		 // Task 3: Check the inputs of given value is divisible by 5.
		 List<Integer> inputs = Arrays.asList(10, 21, 12, 25, 33);
		 IntPredicate lambda2 = x-> x % 5 == 0;
		 printIf(inputs, lambda2);
	}

	public static void changeDouble(List<Integer> numbers, Function action) {
        for (Integer number : numbers) {
			System.out.println(action.apply(number));
        }
	}
	public static void transformStrings(List<String> list, Function transformer) {
        for (String s : list) {
            System.out.println(transformer.apply(s));
        }
    }
	public static void printIf(List<Integer> numbers, IntPredicate condition) {
        for (Integer number : numbers) {
           if (condition.test(number)) {
                System.out.println(number);
		   }
        }
    }
}

