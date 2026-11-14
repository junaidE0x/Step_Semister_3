package DSA_introduction.Class_problems;

import java.util.*;

class ResultCard {
    String name;
    int[] marks;

    ResultCard(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;

        for (int m : marks)
            sum += m;

        return sum / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else if (avg >= 40)
            return 'D';
        else
            return 'F';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int j = 0; j < 3; j++)
                marks[j] = sc.nextInt();

            ResultCard s = new ResultCard(name, marks);

            System.out.printf(
                    "%s: Average %.1f, Grade %c%n",
                    s.name.toUpperCase(), s.average(), s.grade()
            );
        }

        sc.close();
    }
}

