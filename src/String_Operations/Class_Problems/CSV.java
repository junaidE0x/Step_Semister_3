package String_Operations.Class_Problems;

import java.util.Scanner;

public class CSV {
    public static void parseStudentRecord(String csvLine){
        String[] s=csvLine.split(",");
        if(s.length!=3){
            System.out.println("Invalid Record");
        }
        else{
            System.out.println("Name: " + s[0] + " | Roll No: " + s[1] + " | Dept: " +s[2]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter data:");
        String line= sc.nextLine();

        parseStudentRecord(line);
    }
}
