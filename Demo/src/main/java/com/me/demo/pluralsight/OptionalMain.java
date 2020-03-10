package com.me.demo.pluralsight;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Optional;
import java.util.Set;

public class OptionalMain {

    public static void main(String[] args) {
        Optional<Book> full = Optional.of(getBook());
        full.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing Here"));
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("Nothing Here"));

        Optional<Book> localOffer = Optional.of(getBook());

        Book bestBookOffer = getBestOffer().orElse(getExternalOffer().orElse(localOffer.get()));//Java 8

        Optional<Book> bestBook = getBestOffer()
                                    .or(() -> getExternalOffer())
                                    .or(() -> localOffer);


        System.out.println(bestBook);
        System.out.println(bestBookOffer);

        leapYear();
    }


    public static  Optional<Book> getBestOffer(){
        return Optional.empty();
    }

    public static  Optional<Book> getExternalOffer(){
        return Optional.of(new Book("External Book", Set.of(), 11.99));
    }

    private static Book getBook() {
        return new Book("PluralSight", Set.of("Nigel"), 11.3);
    }

    private static void leapYear(){
        long leapYear = LocalDate.of(1956, 03, 16)
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(date -> Year.of(date.getYear()))
                .filter(Year::isLeap)
                .count();

        System.out.println(leapYear);
    }
}
