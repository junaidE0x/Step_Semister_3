package OOP_Abstraction_Interface.Class_problems;

import java.util.Scanner;

public class Transport {
    static abstract class Journey {
        double distance;

        Journey(double distance) {
            this.distance = distance;
        }

        abstract double fare();
    }

    static class Bus extends Journey {
        Bus(double distance) {
            super(distance);
        }

        double fare() {
            return Math.min(10, 2 + 0.1 * distance);
        }
    }

    static class Train extends Journey {
        Train(double distance) {
            super(distance);
        }

        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Journey {
        double factor;

        Metro(double distance, double factor) {
            super(distance);
            this.factor = factor;
        }

        double fare() {
            return (1.5 + 0.2 * distance) * factor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            Journey j;

            switch (type) {
                case "BUS":
                    j = new Bus(distance);
                    break;
                case "TRAIN":
                    j = new Train(distance);
                    break;
                default:
                    double factor = sc.nextDouble();
                    j = new Metro(distance, factor);
            }

            double amount = j.fare();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
