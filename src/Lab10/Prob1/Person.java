package lesson10.generics.labsolution.prob1;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Implementing the compareTo method to compare based on last name and then first name
    @Override
    public int compareTo(Person other) {
        // Compare by last name first
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        // If last names are equal, compare by first name
        return this.firstName.compareTo(other.firstName);
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

