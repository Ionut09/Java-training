package streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LondonStockExchange {

    static Trader raoul = new Trader("Raoul", "Cambridge");

    static Trader mario = new Trader("Mario", "Milan");

    static Trader alan = new Trader("Alan", "Cambridge");

    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = List.of(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /**
     * 1. Find all transactions in the year 2011 and sort them by value (small to high).
     * 2. What are all the unique cities where the traders work?
     * 3. Find all traders from Cambridge and sort them by name.
     * 4. Return a string of all traders’ names sorted alphabetically.
     * 5. Are any traders based in Milan?
     * 6. Print all transactions’ values from the traders living in Cambridge.
     * 7. What’s the highest value of all the transactions?
     * 8. Find the transaction with the smallest value.
     */
    public static void main(String... args) {
        List<Transaction> transactionList = transactions.stream()
                                                        .filter(transaction -> transaction.getYear() == 2011)
//                                                      .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                                                        .sorted(Comparator.comparing(Transaction::getValue))
                                                        .collect(Collectors.toList());
        print(transactionList);

        //     * 2. What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
//                                              .map(Transaction::getTrader)
//                                              .map(Trader::getCity)
                                                .map(transaction -> transaction.getTrader().getCity())
                                                .distinct()
                                                .collect(Collectors.toList());
        System.out.println(uniqueCities);
        Set<String> uniqueCitiesOfTRaders = transactions.stream()
                                                        .map(transaction -> transaction.getTrader().getCity())
                                                        .collect(Collectors.toSet());

        System.out.println(uniqueCitiesOfTRaders);
        String uniqueCitiesAsStr = transactions.stream()
                                               .map(transaction -> transaction.getTrader().getCity())
                                               .distinct()
                                               .collect(Collectors.joining(", "));

        System.out.println("uniqueCitiesAsStr = " + uniqueCitiesAsStr);

    }


    static void print(Collection<?> set) {
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
