package String.Class_problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int ori = n;
        int rev = 0;

        while(n>0){
            int d = n%10;
            rev = rev * 10 + d;
            n = n/10;
        }

        if(rev == ori){
            System.out.println("Is the no " + ori + " a palindrome? Yes");
        }
        else{
            System.out.println("Is the no " + ori + " a palindrome? No");
        }
    }
}