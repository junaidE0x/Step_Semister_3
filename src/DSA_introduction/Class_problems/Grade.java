package DSA_introduction.Class_problems;

import java.util.*;

class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int marks = sc.nextInt();

            if (marks >= 90)
                System.out.println("Grade A");
            else if (marks >= 75)
                System.out.println("Grade B");
            else if (marks >= 60)
                System.out.println("Grade C");
            else if (marks >= 40)
                System.out.println("Grade D");
            else
                System.out.println("Grade F");
        }

        sc.close();
    }
}

