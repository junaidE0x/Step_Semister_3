package OOP_Abstraction_Interface.Assignment_problems;

import java.util.Scanner;

public class Parking {
    static abstract class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double charge() {
            return hours * 10.0;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double charge() {
            return 30 + (hours - 1) * 20.0;
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double charge() {
            return Math.max(100, hours * 50.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE":
                    v = new Bike(hours);
                    break;
                case "CAR":
                    v = new Car(hours);
                    break;
                default:
                    v = new Truck(hours);
            }

            double amount = v.charge();
            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
