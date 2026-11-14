package DSA_Revision.Class_problems;

import java.util.*;

interface PaymentMode {
    double processPayment(double amount);
    double getFee(double amount);
    String getMode();
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount * 1.02;
    }

    public double getFee(double amount) {
        return amount * 0.02;
    }

    public String getMode() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "UPI";
    }
}

class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            if (mode.equals("Cash"))
                payments[i] = new CashPayment();
            else if (mode.equals("Card"))
                payments[i] = new CardPayment();
            else
                payments[i] = new UpiPayment();
        }

        for (int i = 0; i < n; i++) {
            double amount = amounts[i];
            double fee = payments[i].getFee(amount);
            double processed = payments[i].processPayment(amount);

            System.out.println(payments[i].getMode() +
                    ": amount " + amount + ", fee " + fee +
                    ", processed " + processed);

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);
    }
}

