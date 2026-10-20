package OOP_Methods_UML.Class_problems;


import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double bill() {
        if (units <= 100) {
            return units * 5;
        }
        return 500 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6, 1000);
    }
}

class Electricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection c;

            switch (type) {
                case "HOME":
                    c = new Home(units);
                    break;
                case "SHOP":
                    c = new Shop(units);
                    break;
                default:
                    c = new Factory(units);
            }

            double bill = c.bill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

