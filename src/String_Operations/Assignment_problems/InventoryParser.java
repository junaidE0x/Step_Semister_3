package String_Operations.Assignment_problems;

import java.util.Scanner;

public class InventoryParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if(fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            String productName = fields[0].trim();
            String sku = fields[1].trim();
            String qty = fields[2].trim();

            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + qty);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Data: ");
        String sentence = sc.nextLine();

        parseInventoryRecord((sentence));

        sc.close();
    }
}
