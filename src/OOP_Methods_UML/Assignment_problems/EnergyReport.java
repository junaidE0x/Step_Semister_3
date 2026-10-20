package OOP_Methods_UML.Assignment_problems;


import java.util.*;

interface Saver {
    double reduce(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements Saver {
    AC(double hours) {
        super(hours);
    }

    double power() {
        return 1500;
    }

    public double reduce(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements Saver {
    Washer(double hours) {
        super(hours);
    }

    double power() {
        return 500;
    }

    public double reduce(double units) {
        return units * 0.75;
    }
}

class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver) {
                sc.next();
            }

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                default:
                    a = new Washer(hours);
            }

            if (saver && !(a instanceof Saver)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units();

            if (saver) {
                units = ((Saver) a).reduce(units);
            }

            double cost = units * 8;
            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
            );
            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}

