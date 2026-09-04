package String_Operations.Class_Problems;

import java.util.Scanner;

public class FileExt {
    public static String validateFileExtension(String filename){
        String[] list = {"pdf", "docx", "zip"};
        int last = filename.lastIndexOf(".");
        String sub = filename.substring(last+1);

        if(last == -1){
            return "Rejected - invalid file type";
        }

        for(String element : list){
            if(element.equalsIgnoreCase(sub)){
                return "Accepted";
            }
        }
        return "Rejected - invalid file type";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter filename:");
        String name = sc.nextLine();

        System.out.println(validateFileExtension(name));
    }
}
