package DSA_sorting.Class_problems;

import java.util.*;

class Library {
    static String findBook(String[] isbn, String[] title, String target) {
        int low = 0, high = isbn.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = isbn[mid].compareTo(target);

            if (cmp == 0)
                return title[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[] isbn = {
                "0001112223", "0002223334", "0003334445",
                "0004445556", "0005556667"
        };

        String[] title = {
                "Introduction to Algebra", "Beginning Python",
                "Classic Mythology", "Data and Society",
                "European History"
        };

        System.out.println(findBook(isbn, title, "0003334445"));
        System.out.println(findBook(isbn, title, "0009998887"));
    }
}

