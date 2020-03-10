package com.me.demo.pluralsight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) throws IOException{
        beforeSteamNullable();

        streamNullable();

        dropAndTakeWhile();

        groupByEvenOdd();

        groupByFiltering();

    }

    private  static void groupByFiltering(){

        List<Book> books = List.of(getBook());
        Map<Set<String>, Set<Book>> bookByAuthors = books.stream()
                .collect(groupingBy(Book::getAuthors,
                        filtering(b -> b.getPrice() > 10, toSet())));

        bookByAuthors.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    private static void groupByEvenOdd(){
        Map<Integer, List<Integer>> ints = Stream.of(1,2,3,4,5,6,7,8,9)
                .collect(groupingBy(i -> i % 2, toList()));
        ints.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    private static void dropAndTakeWhile() throws IOException {
        Files.lines(Paths.get("C:\\WorkSpase\\z_Intellij\\Demo\\src\\main\\resources\\index.html"))
                .dropWhile(l -> !l.contains("<<<<<<<"))
                .skip(1)
                .takeWhile(l -> !l.contains(">>>>>>>"))
                .forEach(System.out::println);
    }

    private static void streamNullable() {
        Stream.ofNullable(getPossiblyNull(false))
                .flatMap(b -> b.getAuthors().stream())
                .forEach(System.out::println);
    }

    private static void beforeSteamNullable() {
        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(getBook()).count();

        System.out.printf("Zero: %d, one: %d", zero, one);

        Book book = getPossiblyNull(false);

        Stream<String> authors = book == null ? Stream.empty() : book.getAuthors().stream();
        authors.forEach(System.out::println);
    }

    private static Book getPossiblyNull(boolean isNull) {
        return isNull ? null : getBook();
    }

    private static Book getBook() {
        return new Book("PluralSight", Set.of("Nigel"), 11.3);
    }


}
