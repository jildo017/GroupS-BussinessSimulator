public class GroupS_BusinessSimulator {

    public static void main(String[] args) {
        String[] names = { "Jersey", "Ball", "Shoes (pair)", "Gym Gloves" };
        int[] prices = { 35000, 25000, 80000, 15000 };
        int[] quantities = { 5, 3, 3, 2 };

        displayPriceList(names, prices);

        int[] subtotals = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            subtotals[i] = calculateSubtotal(i, prices[i], quantities[i]);
        }

        int grandTotal = 0;
        for (int i = 0; i < subtotals.length; i++) {
            grandTotal = grandTotal + subtotals[i];
        }

        printReceipt(names, quantities, subtotals, grandTotal);
    }

    public static void displayPriceList(String[] names, int[] prices) {
        System.out.println("ProSport Shop Price List ");
        int itemNumber = 1;
        for (int i = 0; i < names.length; i++) {
            System.out.println(itemNumber + ". " + names[i] + " - " + prices[i] + " UGX");
            itemNumber++;
        }
        System.out.println("\n");
    }

    public static int calculateSubtotal(int itemPos, int unitPrice, int qty) {
        int subtotal = unitPrice * qty;
        if (itemPos == 0 && qty >= 3) {
            subtotal = subtotal * 95 / 100;
        } else if (itemPos == 2 && qty >= 2) {
            subtotal = subtotal - 8000;
        } else if (itemPos == 3 && qty >= 4) {
            subtotal = subtotal * 90 / 100;
        }
        return subtotal;
    }

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

    public static void printReceipt(String[] names, int[] quantities, int[] subtotals, int grandTotal) {
        System.out.println(" Receipt ");
        for (int i = 0; i < names.length; i++) {
            String note = discountNote(i, quantities[i]);
            System.out.println(names[i] + " x " + quantities[i] + " = " + subtotals[i] + " UGX (" + note + ")");
        }
        System.out.println("");
        System.out.println("Grand Total: " + grandTotal + " UGX");
    }
}
