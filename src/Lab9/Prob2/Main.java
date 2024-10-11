package Lab9.Prob2;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


    }

    public static void printSquares(int num) {
        Stream.iterate(1, x -> x + 2)
                .skip(4)
                .limit(4)
                .forEach(System.out::println);
    }

}
