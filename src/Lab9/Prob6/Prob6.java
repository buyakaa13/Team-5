package Lab9.Prob6;

import java.util.*;
import java.util.stream.Collectors;

public class Prob6 {
    public static void main(String[] args) {
        List<Set<String>> sets = List.of(Set.of("A", "B"), Set.of("D"), Set.of("1", "3", "5"));
        Prob6 prob6 = new Prob6();
        System.out.println("Set: " + prob6.union(sets));
    }

    //Set<String>
    public Set<String> union(List<Set<String>> sets){
         return sets.stream()
                .map(x-> x.stream().reduce((y, z)-> y.concat("," + z)).get())
                 .collect(Collectors.toSet());
    }
}
