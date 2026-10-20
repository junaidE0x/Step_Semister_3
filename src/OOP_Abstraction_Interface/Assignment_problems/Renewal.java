package OOP_Abstraction_Interface.Assignment_problems;

import java.util.Scanner;
import java.time.LocalDate;

public class Renewal {
    static abstract class Plan {
        String name;
        LocalDate start;

        Plan(String name, String start) {
            this.name = name;
            this.start = LocalDate.parse(start);
        }

        abstract int days();

        LocalDate renewalDate() {
            return start.plusDays(days());
        }
    }

    static class Basic extends Plan {
        Basic(String name, String start) {
            super(name, start);
        }

        int days() {
            return 30;
        }
    }

    static class Standard extends Plan {
        Standard(String name, String start) {
            super(name, start);
        }

        int days() {
            return 90;
        }
    }

    static class Premium extends Plan {
        Premium(String name, String start) {
            super(name, start);
        }

        int days() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            String date = sc.next();
            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic(name, date);
                    break;
                case "STANDARD":
                    p = new Standard(name, date);
                    break;
                default:
                    p = new Premium(name, date);
            }

            System.out.println(p.name + ": " + p.renewalDate());
        }

        sc.close();
    }
}
