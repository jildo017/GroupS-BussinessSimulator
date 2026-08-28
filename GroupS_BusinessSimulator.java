// Group S - ProSport Shop
// A simple till system: shows prices, works out discounts, prints a receipt.

public class GroupS_BusinessSimulator {

    public static void main(String[] args) {

        // Three arrays, linked by position.
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

    // Prints the price list using a loop, instead of typing 4 println lines
    public static void displayPriceList(String[] names, double[] prices) {
        System.out.println(" ProSport Shop Price List ");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + prices[i] + " UGX");
        }
        System.out.println("\n");
    }

    // Works out ONE item's subtotal, and applies its discount rule if it qualifies.
    // "index" tells us WHICH item this is (0 = Jersey, 1 = Ball, 2 = Shoes, 3 =
    // Gloves)
    public static double calculateSubtotal(int index, double price, int quantity) {
        double total = price * quantity; // plain total, before any discount

        if (index == 0 && quantity >= 3) {
            // Jersey: 5% off if buying 3 or more
            total = total * 0.95;
        } else if (index == 1) {
            // Ball: no rule here on purpose - it is never discounted
        } else if (index == 2 && quantity >= 2) {
            // Shoes (pair): flat UGX 8,000 off if buying 2 or more
            total = total - 8000;
        } else if (index == 3 && quantity >= 4) {
            // Gym Gloves: 10% off if buying 4 or more
            total = total * 0.90;
        }

        return total;
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