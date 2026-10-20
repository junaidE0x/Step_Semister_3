package OOP_Abstraction_Interface.Class_problems;

import java.util.Scanner;

public class Payment {
    static abstract class Method {
        double amount;

        Method(double amount) {
            this.amount = amount;
        }

        abstract double calculate();
    }

    static class Card extends Method {
        Card(double amount) {
            super(amount);
        }

        double calculate() {
            return amount * 1.02;
        }
    }

    static class Wallet extends Method {
        Wallet(double amount) {
            super(amount);
        }

        double calculate() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Method {
        BankTransfer(double amount) {
            super(amount);
        }

        double calculate() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            Method m;

            switch (type) {
                case "CARD":
                    m = new Card(amount);
                    break;
                case "WALLET":
                    m = new Wallet(amount);
                    break;
                default:
                    m = new BankTransfer(amount);
            }

            double result = m.calculate();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
