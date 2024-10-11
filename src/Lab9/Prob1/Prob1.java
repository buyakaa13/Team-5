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
                .filter(x->x.contains(String.valueOf(c)) && !x.contains(String.valueOf(d)) && x.length() == len)
                .count();

        return Integer.parseInt(String.valueOf(result));
    }
}
