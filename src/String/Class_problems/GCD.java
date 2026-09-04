package String.Class_problems;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 2 numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int n3 = n1;
        int n4 = n2;

        while(n2 != 0){
            int rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }

        System.out.println("The GCD of " + n3 +" and " + n4 +" is "+ n1);
        sc.close();
    }
}
