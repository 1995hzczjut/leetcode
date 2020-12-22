package com.jdk8.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Zhancong Huang
 * @date 18:44 2019/3/4
 */
public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Q1
        List<Transaction> list1 = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((t1, t2) -> t1.getYear() - t2.getYear())
                .collect(Collectors.toList());
        //Q2
        List<String> list2 = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        //Q3
        List<Trader> list3 = transactions
                .stream()
                .map(t -> t.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());
    }
}
