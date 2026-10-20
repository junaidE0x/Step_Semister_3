package OOP_Methods_UML.Assignment_problems;


import java.util.*;

abstract class Ticket {
    static final double FEE = 20;

    abstract double price();

    double amount(int count) {
        return (price() + FEE) * count;
    }
}

class Regular extends Ticket {
    double price() {
        return 150;
    }
}

class Premium extends Ticket {
    double price() {
        return 250;
    }
}

class Recliner extends Ticket {
    double price() {
        return 400;
    }
}

class TicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;

            switch (seat) {
                case "REGULAR":
                    t = new Regular();
                    break;
                case "PREMIUM":
                    t = new Premium();
                    break;
                default:
                    t = new Recliner();
            }

            double amount = t.amount(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

