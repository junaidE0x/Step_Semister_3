package OOP_Methods_UML.Assignment_problems;


import java.util.*;

interface Insurable {
    double insurance(double value);
}

abstract class Parcel {
    double weight;

    Parcel(double weight) {
        this.weight = weight;
    }

    abstract double charge();

    double insurance(double value) {
        return 0;
    }
}

class Standard extends Parcel {
    Standard(double weight) {
        super(weight);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight) {
        super(weight);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance(double value) {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight) {
        super(weight);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance(double value) {
        return value * 0.02;
    }
}

class ParcelDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(weight);
                    break;
                case "EXPRESS":
                    p = new Express(weight);
                    break;
                default:
                    p = new Fragile(weight);
            }

            double charge = p.charge();
            double insurance = p.insurance(value);
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

