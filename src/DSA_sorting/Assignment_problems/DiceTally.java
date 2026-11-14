package DSA_sorting.Assignment_problems;

import java.util.*;

class DiceTally {
    static void diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls)
            count[roll]++;

        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i]);

            if (i < 6)
                System.out.print(" ");
        }

        System.out.println();

        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                rolls[index++] = i;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(rolls));
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 2, 4, 1, 4, 6};
        diceSort(rolls);
    }
}

