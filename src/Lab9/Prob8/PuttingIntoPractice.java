package Lab9.Prob8;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(x->x.getYear() == 2011)
                .sorted(Comparator.comparing(x->x.getValue()))
                .forEach(System.out::println);

        
        // Query 2: What are all the unique cities where the traders work?
        transactions.stream()
                .map(x->x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .filter(x->x.getTrader().getCity() == "Cambridge")
                .map(x->x.getTrader())
                .sorted(Comparator.comparing(x->x.getName()))
                .forEach(System.out::println);

        // Query 4: Return a string of all traders names sorted alphabetically.
        String traderNames = transactions.stream()
                .map(x->x.getTrader().getName())
                .distinct()
                .sorted()
                .reduce((x, y)->x.concat(","+y)).get();
        System.out.println("All traders names: " + traderNames);

        // Query 5: Are there any trader based in Milan?
        boolean hasTrader = transactions.stream()
                .filter(x->x.getTrader().getCity() == "Milan")
                .findFirst().isPresent();
        System.out.println("Trader based in Milan: " + hasTrader);

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                .filter(x->x.getTrader().getCity() == "Milan")
                .forEach(x->x.getTrader().setCity("Cambridge"));

        // Query 7: What's the highest value in all the transactions?
        IntSummaryStatistics sum = transactions.stream()
                .collect(Collectors.summarizingInt(x->x.getValue()));
        System.out.println("Highest value: " + sum.getMax());
    }
}
