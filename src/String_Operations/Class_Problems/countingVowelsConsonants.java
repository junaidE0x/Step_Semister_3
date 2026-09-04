package String_Operations.Class_Problems;

import java.util.Scanner;

public class countingVowelsConsonants {
    public static void countingVowelsAndConsonants(String text){
        int v=0;
        int c=0;

        for(int i=0; i<text.length(); i++){
            char ch=Character.toLowerCase(text.charAt(i));

            if((ch=='a') || (ch=='e') || (ch=='i') || (ch=='o') || (ch=='u')){
                v++;
            }
            else if(ch!=' '){
                c++;
            }
        }

        System.out.println("Vowels: " + v + " | Consonants: " + c);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        countingVowelsAndConsonants(input);
    }
}
