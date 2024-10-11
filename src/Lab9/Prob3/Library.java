package Lab9.Prob3;

import java.util.List;

public class Library {
    private String name;
    private List<String> books;

    // Constructor
    public Library(String name, List<String> books) {
        this.name = name;
        this.books = books;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public List<String> getBooks() {
        return books;
    }
}
