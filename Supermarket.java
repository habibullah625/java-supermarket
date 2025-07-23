/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kheal
 */
public class Supermarket {

   // List of market items
    private static final ProductData[] marketItems = {
        // EdibleProduct examples
        new ProductData("E001", "Banana", 60, "2025-05-11", null, 0, "Fruit", 100, 120.0, 10.0, 0.0, null, new String[]{"Fructose"}, null, false),
        new ProductData("E002", "Wheat Flour", 50, "2026-04-27", null, 0, "Grain", 80, 1000.0, 0.0, 0.0, null, new String[]{"Gluten"}, null, false),
        new ProductData("E003", "Milk", 70, "2025-05-04", null, 0, "Dairy", 60, 1000.0, 5.0, 0.0, null, new String[]{"Lactose"}, null, false),
        new ProductData("E004", "Lentils", 120, "2026-04-27", null, 0, "Pulse", 90, 500.0, 0.0, 0.0, null, null, null, false),
        new ProductData("E005", "Tomato", 40, "2025-05-11", null, 0, "Vegetable", 120, 100.0, 0.0, 0.0, null, null, null, false),
        new ProductData("E006", "Sugar", 45, "2027-04-27", null, 0, "Sweetener", 70, 1000.0, 0.0, 0.0, null, null, null, false),
        new ProductData("E007", "Butter", 100, "2025-07-27", null, 0, "Dairy", 40, 500.0, 10.0, 0.0, null, new String[]{"Lactose", "Dairy"}, null, false),
        // NonEdibleProduct examples
        new ProductData("N001", "Shampoo", 150, null, "Shine", 1, "Personal Care", 50, 250.0, 10.0, 0.0, null, null, new String[]{"Keep out of eyes"}, false),
        new ProductData("N002", "Detergent", 80, null, "Tide", 1, "Cleaning", 60, 1000.0, 5.0, 0.0, null, null, new String[]{"Irritant", "Do not ingest"}, false),
        new ProductData("N003", "Toothpaste", 90, null, "DentalPro", 1, "Personal Care", 70, 150.0, 0.0, 0.0, null, null, null, false),
        // BeverageProduct examples
        new ProductData("B001", "Orange Juice", 120, "2025-06-15", null, 2, "Beverage", 50, 1000.0, 15.0, 1000.0, "2025-06-15", null, null, false),
        new ProductData("B002", "Cola", 80, "2025-12-31", null, 2, "Beverage", 100, 1200.0, 5.0, 1500.0, "2025-12-31", null, null, true),
        new ProductData("B003", "Mineral Water", 40, "2026-01-01", null, 2, "Beverage", 200, 1000.0, 0.0, 2000.0, "2026-01-01", null, null, false)
    };
    private static final int EXIT = marketItems.length + 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShoppingTrolley myBag = new ShoppingTrolley(); // this is myBag. I can buy things to put in it
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        // Main application loop. Continues until the user checks out.
        while (isRunning) {
            showMenu();
            int choice = readChoice(input);
            isRunning = processChoice(myBag, input, choice);
        }

        System.out.println("\nThank you for shopping with us!");
    }

    /**
     * Show menu
     */
    private static void showMenu() {
        System.out.println("===== MARKET MENU =====");
        for (int index = 0; index < marketItems.length; index++) {
            System.out.println((index + 1) + ". Buy " + marketItems[index].productName);
        }
        System.out.println(EXIT + ". Checkout");
    }
    
     /**
     * Read a valid menu choice from the user.
     * Keeps prompting until a valid integer is entered.
     * @param input Scanner for user input
     * @return A valid menu choice
     */
    private static int readChoice(Scanner input) {
        int choice = -1;
        do {
            System.out.print("Enter choice: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (!isChoiceValid(choice)) {
                    System.out.println("Invalid choice. Pick a number from 1 to " + EXIT + ".");
                    choice = -1; // Reset choice to ensure loop continues
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the invalid input
                choice = -1;     // Reset choice to ensure loop continues
            }
        } while (!isChoiceValid(choice));
        return choice;
    }

    /**
     * Checks if the user's menu choice is within the valid range.
     * @param choice The integer choice to validate.
     * @return true if the choice is valid, false otherwise.
     */
    private static boolean isChoiceValid(int choice) {
        return choice >= 1 && choice <= EXIT;
    }
    
     /**
     * Process user choice. Adds item to trolley or checks out.
     * @param shopTrolley The user's shopping trolley
     * @param input Scanner for user input
     * @param choice The user's menu choice
     * @return false if the user checks out, true otherwise.
     */
    private static boolean processChoice(ShoppingTrolley shopTrolley, Scanner input, int choice) {
        if (choice == EXIT) {
            checkout(shopTrolley);
            return false; // Signals the main loop to stop
        }
        addToTrolley(shopTrolley, input, choice - 1);
        return true; // Signals the main loop to continue
    }
    
    /**
     * Add products to trolley.
     */
    private static void addToTrolley(ShoppingTrolley shopTrolley, Scanner input, int itemIndex) {
        int quantity = promptForQuantity(input);
        addProductsToTrolley(shopTrolley, itemIndex, quantity);
        System.out.println("Products added to your trolley.");
    }

    /**
     * Prompt the user for a valid quantity.
     * @param input Scanner for user input
     * @return Valid quantity (int > 0)
     */
    private static int promptForQuantity(Scanner input) {
        System.out.print("Enter quantity (How much do you want?): ");
        int quantity = 0;
        boolean invalid = true;
        while (invalid) {
            if (input.hasNextInt()) {
                quantity = input.nextInt();
                if (quantity > 0) {
                    invalid = false;
                } else {
                    System.out.println("Need number more than 0.");
                    System.out.print("Enter quantity (How much do you want?): ");
                }
            } else {
                System.out.println("Need number more than 0.");
                input.nextLine();
                System.out.print("Enter quantity (How much do you want?): ");
            }
        }
        return quantity;
    }

    /**
     * Add the specified quantity of a product to the trolley.
     * @param shopTrolley The user's shopping trolley
     * @param itemIndex Index of the product in marketItems
     * @param quantity Number of items to add
     */
    private static void addProductsToTrolley(ShoppingTrolley shopTrolley, int itemIndex, int quantity) {
        for (int index = 0; index < quantity; index++) {
            ProductData data = marketItems[itemIndex];
            StoreItem product = createProduct(data);
            shopTrolley.buyItem(product);
        }
    }
    
    /**
     * Create product by type.
     * Note: One if needed for EdibleProduct vs. NonEdibleProduct.
     */
    private static StoreItem createProduct(ProductData data) {
        if (data.productType == 0) {
            return new EdibleProduct(
                data.productName, data.productID, data.productCost, data.expiryDate,
                data.category, data.stockQuantity, data.weight, data.discount, data.allergens
            );
        } else if (data.productType == 1) {
            return new NonEdibleProduct(
                data.productName, data.productID, data.productCost, data.productBrand,
                data.category, data.stockQuantity, data.weight, data.discount, data.safetyWarnings
            );
        } else if (data.productType == 2) {
            return new BeverageProduct(
                data.productName, data.productID, data.productCost, data.expiryDate,
                data.category, data.stockQuantity, data.weight, data.discount, data.volume, data.isCarbonated
            );
        }
        return null;
    }
    
    /**
     * Checkout and show receipt.
     */
    private static void checkout(ShoppingTrolley shopTrolley) {
        System.out.println("\n****** Receipt ******");
        ArrayList<Object> items = shopTrolley.getItems();
        if (items.isEmpty()) {
            System.out.println("Sorry! Your trolley is Empty.");
        } else {
            printReceipt(items);
            shopTrolley.emptyTrolley();
        }
    }

    /**
     * Print the receipt for the given items, showing discounts and totals.
     * @param items List of purchased items
     */
    private static void printReceipt(ArrayList<Object> items) {
        System.out.println("Your Selected Items:");
        double total = 0;
        double totalDiscount = 0;
        int i = 0;
        for (Object item : items) {
            i++;
            double[] itemTotals = processAndPrintItem(i, (StoreItem) item);
            total += itemTotals[0]; // Add final price to total
            totalDiscount += itemTotals[1]; // Add discount amount to total discount
        }
        // Print totals
        System.out.printf("Total Discount: Rs.%.2f\n", totalDiscount);
        System.out.printf("Total Bill: Rs.%.2f\n", total);
    }

    /**
     * Processes a single item for the receipt: calculates its price,
     * prints its details, and returns the calculated values.
     * @param itemNumber The line number for the item on the receipt.
     * @param item The StoreItem to process.
     * @return A double array where index 0 is the final price and index 1 is the discount amount.
     */
    private static double[] processAndPrintItem(int itemNumber, StoreItem item) {
        double price = item.getProductCost();
        double discount = item.getDiscount();
        double discountAmount = price * (discount / 100.0);
        double finalPrice = price - discountAmount;

        // Print details for this specific item
        System.out.printf("%d- %s | Original: Rs.%.2f | Discount: %.1f%% | Final: Rs.%.2f\n",
                itemNumber, item.describe(), price, discount, finalPrice);

        return new double[]{finalPrice, discountAmount};
    }

     // Holds product details
    private static class ProductData {
        String productID;
        String productName;
        int productCost;
        String expiryDate; // For edible and beverage
        String productBrand; // For non-edible
        int productType; // 0 for EdibleProduct, 1 for NonEdibleProduct, 2 for BeverageProduct
        String category;
        int stockQuantity;
        double weight;
        double discount;
        double volume; // For beverage
        String beverageExpiry; // For beverage (duplicate for clarity)
        String[] allergens; // For edible
        String[] safetyWarnings; // For non-edible
        boolean isCarbonated; // For beverage

        ProductData(String productID, String productName, int productCost, String expiryDate, String productBrand, int productType,
                    String category, int stockQuantity, double weight, double discount, double volume, String beverageExpiry,
                    String[] allergens, String[] safetyWarnings, boolean isCarbonated) {
            this.productID = productID;
            this.productName = productName;
            this.productCost = productCost;
            this.expiryDate = expiryDate;
            this.productBrand = productBrand;
            this.productType = productType;
            this.category = category;
            this.stockQuantity = stockQuantity;
            this.weight = weight;
            this.discount = discount;
            this.volume = volume;
            this.beverageExpiry = beverageExpiry;
            this.allergens = allergens;
            this.safetyWarnings = safetyWarnings;
            this.isCarbonated = isCarbonated;
        }
    }

}
