package com.me.demo.ikmtest;

import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyCollection<T> {

    private Set<T> set;
    public Set<T> getCollection(){
        return this.set;
    }
}

class TestMyCollection{

    public static void main(String[] args) {
        System.out.println("main 1");
    }
    public static void main() {
        System.out.println("main 2");
    }

    public void testCollection(MyCollection<?> collection){
        Set set1 = collection.getCollection();
        //Set<T> set2 = collection.getCollection();
        //Set<> set3 = collection.getCollection();
        Set<?> set4 = collection.getCollection();

    }
}

class Invoice{
    public static  String formatId(String oldId){
        return oldId + "_Invoice";
    }
}

class SalesInvoice extends Invoice{
    public static  String formatId(String oldId){
        return oldId + "_SalesInvoice";
    }
}

class InvoiceTest{
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        System.out.println(invoice.formatId("1234"));

        SalesInvoice invoice1 = new SalesInvoice();
        System.out.println(invoice1.formatId("1234"));

        Invoice invoice2 = new SalesInvoice();
        System.out.println(invoice2.formatId("1234"));

        Invoice invoice3 = new Invoice();
        //System.out.println((SalesInvoice)Invoice.formatId("1234"));


    }
}

class ExceptionDemo{
    public static void main(String[] args) {
        String a = null;
        Optional<String> b = Optional.empty();
        System.out.println(Optional.ofNullable(a).orElse("www").length());
        try{
            System.out.print(a.length());
            System.out.println(b.orElse("").length());
        } catch (Exception ex){
            System.out.print(a);
        } finally {
            a = "String";
            System.out.print(a.length());
            b = Optional.ofNullable("");
            System.out.println(b.get().length());
        }
    }
}

class TestDateTime{
    public static void main(String[] args) {
        YearMonth ym1 = YearMonth.of(2015, Month.SEPTEMBER);
        YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
        System.out.println(ym2.compareTo(ym1));
        System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());
        System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));
        System.out.println(ym2.until(ym1, ChronoUnit.MONTHS));

        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());

        c.andThen(d).accept(i.get());
        System.out.println();

        System.out.println(new Double("17.46d"));
        System.out.println(new Boolean("g"));
        System.out.println(new Float("23.43"));
    }
}

interface DefaultInterface{
    default String getSomeThing(){
        return "Some Thing";
    }
}