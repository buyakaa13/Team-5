package Lab9.Prob2;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Prob2 {
    public static void main(String[] args) {
        printSquares(4);
    }

    public static void printSquares(int num){
        IntStream.iterate(1, x->x+1)
                .limit(num)
                .map(x->x*x)
                .forEach(System.out::println);
    }
}
