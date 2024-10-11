package Lab9.Prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibrarySystem {
    public static void main(String[] args) {

        // Created libraries

        Library library1 = new Library("City Library", List.of("Origin", "Inferno", "Dune", "Foundation"));
        Library library2 = new Library("Town Library", List.of("Twilight", "Outliers"));
        Library library3 = new Library("Village Library", List.of("Becoming", "Leadership", "Creativity", "Sapiens", "Rebecca"));

        // Task 1. Create a list of libraries from the given three Library objects
        List<Library> libraries = new ArrayList<>(Arrays.asList(library1, library2, library3));

        // Task 2: Filter libraries that have more than 3 books and print the name of the Library
        System.out.println("Library ------------------");
        libraries.stream()
                .filter(x->x.getBooks().size() > 3)
                .forEach(x->System.out.println(x.getName()));

        // Task 3: FlatMap to get all the book titles from the libraries and print the results on the console
        System.out.println("All books ---------------");
        libraries.stream()
                .flatMap(x->x.getBooks().stream())
                .forEach(System.out::println);

    }
}
