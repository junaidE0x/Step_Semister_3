package OOP_Methods_UML.Class_problems;


import java.util.*;

abstract class Travel {
    static final double FEE = 50;
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double fare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double fare() {
        return 2500 + distance * 4;
    }
}

class Booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel t;

            switch (mode) {
                case "BUS":
                    t = new Bus(distance);
                    break;
                case "TRAIN":
                    t = new Train(distance);
                    break;
                default:
                    t = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, t.total());
        }

        sc.close();
    }
}

