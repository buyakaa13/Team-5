package Lab9.Prob6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob6 {
    public static void main(String[] args) {

        List<Set<String>> listOfSets = new ArrayList<>();
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");

        Set<String> set2 = new HashSet<>();
        set2.add("D");

        Set<String> set3 = new HashSet<>();
        set3.add("1");
        set3.add("2");
        set3.add("3");

        // Add the Sets to the List
        listOfSets.add(set1);
        listOfSets.add(set2);
        listOfSets.add(set3);
//        [{“A”, “B”}, {“D”}, {“1”, “3”, “5”}]
//        {“A”, “B”, “D”, “1”, “3”, “5”}
        Prob6 prob6 = new Prob6();
        prob6.union(listOfSets);
    }

    //Set<String>
    public void union(List<Set<String>> sets){
         sets.stream()
                .map(x->x.stream().reduce((y, z)-> y.concat("," + z)))
                .forEach(System.out::println);
//         return
    }
}
