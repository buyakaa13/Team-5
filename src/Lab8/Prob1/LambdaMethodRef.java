package Lab8.Prob1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class LambdaMethodRef {
    public static void main(String[] args) {
        String fname = "Tom";
        String lname = "Bruce";
        // Imperative code
        String com = fname + " " +lname;
        System.out.println(com);
       
        /* Task 1 - Must provide a space between first and last name
           a) Convert the concatenation task of imperative code to lambda, 
           which takes two string inputs and return a string.
           b) Do the same using Method Reference
           c) Print the result on console by invoking the
              Lambda and Method Reference object
        */
       
        String[] names1 = {"Alexis", "Tim", "Kyleen", "Bruce", "tom"};
        // Imperative code - Using Arrays.sort with an anonymous Comparator to ignore case
        Arrays.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2); // Ignore case during comparison
            }
        });
        System.out.println("Sored list using imperative");
        for (String name : names1) {
            System.out.println(name);
        }

        /* Task-2
        a.  Use Arrays.sort() to sort the names
            by ignore case using lambda for the above imperative style of code.
        b.  Use Arrays.sort() to sort the names
            by ignore case using Method reference.
        c.  Print the sorted list on console 
         */
       

    }
}
