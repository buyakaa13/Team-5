package Lab9.Prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("jacn", "jacd", "cart", "cavy", "denmark"));

        System.out.println("counted words - with letter c - no letter d - with length 4");
        System.out.println(countWords(names, 'c', 'd', 4));
    }

    public static int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream()
                .filter(x -> x.length() == len)
                .filter(x->x.indexOf(c) !=-1)
                .filter(x-> x.indexOf(d) ==-1)
                .count();
    }


}
