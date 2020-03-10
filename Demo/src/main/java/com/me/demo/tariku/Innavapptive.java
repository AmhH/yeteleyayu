package com.me.demo.tariku;

public class Innavapptive {

    public static void main(String[] args) {
        System.out.println(test(1));
        System.out.println(test(2));
        System.out.println(test(26));
        System.out.println(test(89));
        System.out.println(test(567890));

        printString(4567);
    }

    private static void printString(int columnNumber) {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            // Find remainder
            int rem = columnNumber % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            } else {// If remainder is non-zero
                columnName.append((char) ((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }

        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }

    private static String test(int A) {
        StringBuilder name = new StringBuilder();
        while (A > 0) {
            int mod = A % 26;
            if (mod == 0) {
                name.append('Z');
                A = (A / 26) - 1;
            } else {
                name.append((char) ((mod - 1) + 'A'));
                A = A / 26;
            }

        }

        return name.reverse().toString();
    }
}
