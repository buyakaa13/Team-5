package Lab9.Prob7;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, Character, String> employeeName =
        (list, salary, letter)->list.stream()
                .filter(x->x.getSalary() > salary && Character.toLowerCase(x.getLastName().charAt(0)) >= letter)
                .map(x->x.getFirstName() + " " + x.getLastName())
                .sorted()
                .collect(Collectors.joining(", "));
}
