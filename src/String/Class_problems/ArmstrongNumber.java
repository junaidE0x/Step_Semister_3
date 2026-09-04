package String.Class_problems;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int ori = n;
        int sum = 0;

        while(n>0){
            int d = n%10;
            sum += d*d*d;
            n = n/10;
        }
        if (sum == ori) {
            System.out.println("Is the number " + ori + " an Armstrong number? Yes");
        } else {
            System.out.println("Is the number " + ori + " an Armstrong number? No");
        }

        sc.close();
    }
}
