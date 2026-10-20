package OOP_Abstraction_Interface.Class_problems;

import java.util.Scanner;
import java.time.LocalDate;

public class Library {
    static abstract class Item {
        String title;

        Item(String title) {
            this.title = title;
        }

        abstract int days();

        LocalDate dueDate() {
            return LocalDate.parse("2023-10-26").plusDays(days());
        }
    }

    static class Book extends Item {
        Book(String title) {
            super(title);
        }

        int days() {
            return 14;
        }
    }

    static class DVD extends Item {
        DVD(String title) {
            super(title);
        }

        int days() {
            return 7;
        }
    }

    static class Magazine extends Item {
        Magazine(String title) {
            super(title);
        }

        int days() {
            return 3;
        }
    }

    static String readQuoted(Scanner sc) {
        String first = sc.next();
        if (!first.startsWith("\"")) {
            return first;
        }

        StringBuilder title = new StringBuilder(first.substring(1));

        while (!title.toString().endsWith("\"")) {
            title.append(" ").append(sc.next());
        }

        title.setLength(title.length() - 1);
        return title.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = readQuoted(sc);
            Item item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new Magazine(title);
            }

            System.out.println(item.title + ": " + item.dueDate());
        }

        sc.close();
    }
}
