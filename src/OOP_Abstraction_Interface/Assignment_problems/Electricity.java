package OOP_Abstraction_Interface.Assignment_problems;

import java.util.Scanner;

public class Electricity {
    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double bill();
    }

    static class Single extends Room {
        Single(int units) {
            super(units);
        }

        double bill() {
            return units * 8.0;
        }
    }

    static class Shared extends Room {
        int occupants;

        Shared(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double bill() {
            return units * 6.0 / occupants;
        }
    }

    static class AC extends Room {
        AC(int units) {
            super(units);
        }

        double bill() {
            return units * 10.0 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            Room r;

            switch (type) {
                case "SINGLE":
                    r = new Single(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new Shared(units, occupants);
                    break;
                default:
                    r = new AC(units);
            }

            double amount = r.bill();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
