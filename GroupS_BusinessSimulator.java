// Group S - ProSport Shop
// A simple till system: shows prices, works out discounts, prints a receipt.

public class GroupS_BusinessSimulator {

    public static void main(String[] args) {

        // we have three arrays and they are going to link to one responce
        // Index 0 in every array = Jersey, index 1 = Ball, and so on.
        String[] names = { "Jersey", "Ball", "Shoes (pair)", "Gym Gloves" };
        double[] prices = { 35000, 25000, 80000, 15000 };
        int[] quantities = { 5, 3, 3, 2 }; // how many the customer is buying

        // Show the price list on screen
        displayPriceList(names, prices);

        // Work out the discounted subtotal for each item, one by one
        double[] subtotals = new double[names.length]; // empty array, 4 slots
        for (int i = 0; i < names.length; i++) {
            subtotals[i] = calculateSubtotal(i, prices[i], quantities[i]);
        }

        // Add all 4 subtotals into one grand total
        double grandTotal = 0;
        for (int i = 0; i < subtotals.length; i++) {
            grandTotal = grandTotal + subtotals[i];
        }

        // Print the final receipt
        printReceipt(names, quantities, subtotals, grandTotal);
    }

    // displays all the avilable items and their prices 
   public static void displayPriceList(Striing[] names, double [] price) {
       System.out.println("ProSport Shop Price List ");
       int itemNumber = 1;
       for (int i = 0; i < names.length; i++) {
           System.out.println(itemNumber + ". " + names[i] + " - " + prices[i] + " UGX");
           itemNumber++;
       }
       System.out.println("\n");

     // this helps calculates subtotal for a single item and applies discount if eligible
    // itemPos: 0 = Jersey, 1 = Ball, 2 = Shoes, 3 = Gloves
    public static double calculateSubtotal(int itemPos, double unitPrice, int qty) {
        double subtotal = unitPrice * qty; // initial total before discount

        if (itemPos == 0 && qty >= 3) {
            // Jersey: 5% discount when buying 3 or more
            subtotal = subtotal * 0.95;
        } else if (itemPos == 1) {
            // Ball: no discount rule for this item
        } else if (itemPos == 2 && qty >= 2) {
            // Shoes (pair): flat 8,000 UGX off when buying 2 or more
            subtotal = subtotal - 8000;
        } else if (itemPos == 3 && qty >= 4) {
            // Gym Gloves: 10% off when buying 4 or more
            subtotal = subtotal * 0.90;
        }

        return subtotal;
    }

    // Turns an item's index into a plain-English note for the receipt
    public static String discountNote(int index, int quantity) {
        if (index == 0) {
            return quantity >= 3 ? "5% discount applied" : "no discount - buy 3+";
        } else if (index == 1) {
            return "no discount available";
        } else if (index == 2) {
            return quantity >= 2 ? "8,000 UGX off applied" : "no discount - buy 2+";
        } else if (index == 3) {
            return quantity >= 4 ? "10% discount applied" : "no discount - buy 4+";
        }
        return "";
    }

    // Prints one line per item (quantity, subtotal, discount note), then the total
    public static void printReceipt(String[] names, int[] quantities, double[] subtotals, double grandTotal) {
        System.out.println(" Receipt ");
        for (int i = 0; i < names.length; i++) {
            String note = discountNote(i, quantities[i]);
            System.out.printf("%s x %d = %.2f UGX (%s)\n", names[i], quantities[i], subtotals[i], note);
        }
        System.out.println("");
        System.out.printf("Grand Total: %.2f UGX\n", grandTotal);
    }
}
