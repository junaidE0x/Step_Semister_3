package String.Assignment_problems;

import java.util.Scanner;

public class SeatDuplicator {
    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;

        for(int i = 0; i < seatNumbers.length; ++i) {
            for(int j = i + 1; j < seatNumbers.length; ++j) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SeatDuplicator sd = new SeatDuplicator();
        System.out.println("Enter seat numbers:");
        int[] input = new int[5];

        for(int i = 0; i < input.length; ++i) {
            input[i] = sc.nextInt();
        }

        sd.checkDuplicateSeats(input);
        sc.close();
    }
}
