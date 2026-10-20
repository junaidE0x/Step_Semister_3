package OOP_Abstraction_Interface.Class_problems;

import java.util.Scanner;

public class Delivery {
    static abstract class Order {
        double weight, distance;

        Order(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double fee();
    }

    static class Standard extends Order {
        Standard(double w, double d) {
            super(w, d);
        }

        double fee() {
            return 5 + 0.5 * weight + 0.1 * distance;
        }
    }

    static class Express extends Order {
        Express(double w, double d) {
            super(w, d);
        }

        double fee() {
            return 15 + weight + 0.2 * distance;
        }
    }

    static class International extends Order {
        double customs;

        International(double w, double d, double customs) {
            super(w, d);
            this.customs = customs;
        }

        double fee() {
            return 25 + 2 * weight + 0.5 * distance + customs;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Order order;

            switch (type) {
                case "STANDARD":
                    order = new Standard(weight, distance);
                    break;
                case "EXPRESS":
                    order = new Express(weight, distance);
                    break;
                default:
                    double customs = sc.nextDouble();
                    order = new International(weight, distance, customs);
            }

            double amount = order.fee();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}