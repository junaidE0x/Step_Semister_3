package String_Operations.Assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence){
        String[] word = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length; i++){
            StringBuilder temp = new StringBuilder(word[i]);
            temp.reverse();
            sb.append(temp);

            if(i < word.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        String sentence = sc.nextLine();

        System.out.println(reverseEachWord(sentence));

        sc.close();
    }
}
