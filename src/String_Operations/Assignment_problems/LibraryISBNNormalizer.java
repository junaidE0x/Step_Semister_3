package String_Operations.Assignment_problems;

import java.util.Scanner;

public class LibraryISBNNormalizer {
    public static String normalizeCode(String raw) {
        if(raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        if(trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return firstThree + rest;
    }

    public static String validateAndFormat(String code) {
        code = normalizeCode(code);

        if(code.length() != 13) {
            return "Invalid: wrong length";
        }

        for(int i=0; i<code.length(); i++) {
            char ch = code.charAt(i);

            if(i<3) {
                if (!Character.isLetter(ch)) {
                    return "Invalid: publisher code must be 3 letters";
                }
            }
            else {
                if (!Character.isDigit(ch)) {
                    return "Invalid: non-digit body";
                }
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ")
                .append("YEAR: ").append(year).append(" | ")
                .append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        String raw = sc.nextLine();

        System.out.println(validateAndFormat(raw));

        sc.close();
    }
}

