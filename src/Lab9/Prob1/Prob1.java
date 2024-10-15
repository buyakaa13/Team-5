package Lab9.Prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Prob1 {
    public static void main(String[] args) {
        Prob1 prob1 = new Prob1();
        List<String> words = new ArrayList<>(Arrays.asList("Apple", "Banana", "Peach", "Kiwi", "Orange"));
        System.out.println("Count: " + prob1.countWords(words, 'e', 'w', 5));
    }

    public int countWords(List<String> words, char c, char d, int len){
        long result = words.stream()
                //these filter works aswell, just commented out to try another approach
//                .filter(x -> x.length() == len)
//                .filter(x->x.indexOf(c) !=-1)
//                .filter(x-> x.indexOf(d) ==-1)
                .filter(x->x.contains(String.valueOf(c)) && !x.contains(String.valueOf(d)) && x.length() == len)
                .count();

        return Integer.parseInt(String.valueOf(result));
    }
}
