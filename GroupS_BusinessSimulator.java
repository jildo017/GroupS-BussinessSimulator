public class GroupS_BusinessSimulator {
    public static void main(String[] args) {
        // here we see arrays for all the items going to be used in the recipt
        String[] names = { "Jersey", "Ball", "Shoes (pair)", "Gym Gloves" };
        int[] prices = { 35000, 25000, 80000, 15000 };
        int[] quantities = { 5, 3, 3, 2 };

        //  this is call 1 for method 1
        displayPriceList(names, prices);

        // here we add two arrays ,one for the price after discount and the other is for
        // the message applied
        int[] subtotals = new int[names.length];
        String[] notes = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            int subtotal = prices[i] * quantities[i];

            // this the part of the conditional statments
            // that cheacks when one gets a discount or not for any items
            String note;

            if (i == 0) {
                if (quantities[i] >= 3) {
                    subtotal = subtotal * 95 / 100;
                    note = "5% discount applied";
                } else {
                    note = "no discount - buy 3+";
                }
            } else if (i == 1) {
                note = "no discount available";
            } else if (i == 2) {
                if (quantities[i] >= 2) {
                    subtotal = subtotal - 8000;
                    note = "8,000 UGX off applied";
                } else {
                    note = "no discount - buy 2+";
                }
            } else {
                if (quantities[i] >= 4) {
                    subtotal = subtotal * 90 / 100;
                    note = "10% discount applied";
                } else {
                    note = "no discount - buy 4+";
                }
            }

            subtotals[i] = subtotal;
            notes[i] = note;
        }

        // here we calculate the grand total
        int grandTotal = 0;
        for (int i = 0; i < subtotals.length; i++) {
            grandTotal = grandTotal + subtotals[i];
        }

        // this is call 2 for method 2
        printReceipt(names, quantities, subtotals, notes, grandTotal);
    }

    // method 1
    public static void displayPriceList(String[] names, int[] prices) {
        System.out.println("ProSport Shop Price List");
        for (int i = 0; i < names.length; i++) {
            int itemNumber = i + 1;
            System.out.println(itemNumber + ". " + names[i] + " - " + prices[i] + " UGX");
        }
        System.out.println();
    }

    // method 2
    public static void printReceipt(String[] names, int[] quantities, int[] subtotals, String[] notes, int grandTotal) {
        System.out.println(" Receipt ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " x " + quantities[i] + " = " + subtotals[i] + " UGX (" + notes[i] + ")");
        }
        System.out.println();
        System.out.println("Grand Total: " + grandTotal + " UGX");
    }
}
