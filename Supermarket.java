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
        new ProductData("Banana", 60, "2025-05-11", null, 0, "Fruit", 100, 120.0, 10.0, 0.0, null), // 10% discount
        new ProductData("Wheat Flour", 50, "2026-04-27", null, 0, "Grain", 80, 1000.0, 0.0, 0.0, null), // EdibleProduct
        new ProductData("Milk", 70, "2025-05-04", null, 0, "Dairy", 60, 1000.0, 5.0, 0.0, null), // EdibleProduct
        new ProductData("Lentils", 120, "2026-04-27", null, 0, "Pulse", 90, 500.0, 0.0, 0.0, null), // EdibleProduct
        new ProductData("Tomato", 40, "2025-05-11", null, 0, "Vegetable", 120, 100.0, 0.0, 0.0, null), // EdibleProduct
        new ProductData("Sugar", 45, "2027-04-27", null, 0, "Sweetener", 70, 1000.0, 0.0, 0.0, null), // EdibleProduct
        new ProductData("Butter", 100, "2025-07-27", null, 0, "Dairy", 40, 500.0, 10.0, 0.0, null), // EdibleProduct
        new ProductData("Shampoo", 150, null, "Shine", 1, "Personal Care", 50, 250.0, 10.0, 0.0, null), // NonEdibleProduct
        new ProductData("Detergent", 80, null, "Tide", 1, "Cleaning", 60, 1000.0, 5.0, 0.0, null), // NonEdibleProduct
        new ProductData("Toothpaste", 90, null, "DentalPro", 1, "Personal Care", 70, 150.0, 0.0, 0.0, null), // NonEdibleProduct
        // BeverageProduct examples
        new ProductData("Orange Juice", 120, "2025-06-15", null, 2, "Beverage", 50, 1000.0, 15.0, 1000.0, "2025-06-15"), // 15% discount
        new ProductData("Cola", 80, "2025-12-31", null, 2, "Beverage", 100, 1200.0, 5.0, 1500.0, "2025-12-31"),
        new ProductData("Mineral Water", 40, "2026-01-01", null, 2, "Beverage", 200, 1000.0, 0.0, 2000.0, "2026-01-01")
    };
    private static final int EXIT = marketItems.length + 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ShoppingTrolley myBag = new ShoppingTrolley(); //this is myBag. I can buy things to put in it
        Scanner input = new Scanner(System.in);

        // Keep showing menu and processing choice
        while (true) {
            showMenu();
            int choice = readChoice(input);
            processChoice(myBag, input, choice);
        }
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
        System.out.print("Enter choice: ");
    }
    
     /**
     * Read valid choice (1 to EXIT).
     */
    private static int readChoice(Scanner input) {
        int choice = 0;
        boolean invalid = true;
        while (invalid) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice >= 1 && choice <= EXIT) {
                    invalid = false;
                } else {
                    System.out.println("Pick 1 to " + EXIT + ".");
                    showMenu();
                }
            } else {
                System.out.println("Pick 1 to " + EXIT + ".");
                input.nextLine();
                showMenu();
            }
        }
        return choice;
    }
    
     /**
     * Process user choice.
     */
    private static void processChoice(ShoppingTrolley shopTrolley, Scanner input, int choice) {
        while (choice == EXIT) {
            checkout(shopTrolley);
            System.exit(0);
            return;
        }
        addToTrolley(shopTrolley, input, choice - 1);
    }
    
    /**
     * Add products to trolley.
     */
    private static void addToTrolley(ShoppingTrolley shopTrolley, Scanner input, int itemIndex) {
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
        for (int index = 0; index < quantity; index++) {
            ProductData data = marketItems[itemIndex];
            StoreItem product = createProduct(data);
            shopTrolley.buyItem(product);
        }
        System.out.println("Products added to your trolley.");
    }
    
    /**
     * Create product by type.
     * Note: One if needed for EdibleProduct vs. NonEdibleProduct.
     */
    private static StoreItem createProduct(ProductData data) {
        if (data.productType == 0) {
            return new EdibleProduct(
                data.productName, data.productCost, data.expiryDate,
                data.category, data.stockQuantity, data.weight, data.discount
            );
        } else if (data.productType == 1) {
            return new NonEdibleProduct(
                data.productName, data.productCost, data.productBrand,
                data.category, data.stockQuantity, data.weight, data.discount
            );
        } else if (data.productType == 2) {
            return new BeverageProduct(
                data.productName, data.productCost, data.expiryDate,
                data.category, data.stockQuantity, data.weight, data.discount, data.volume
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
            // Show each item
            System.out.println("Your Selected Items:");
            double total = 0;
            double totalDiscount = 0;
            int i = 0;
            for (Object item : items) {
                i++;
                StoreItem totalItem = (StoreItem) item;
                double price = totalItem.getProductCost();
                double discount = totalItem.getDiscount();
                double discountAmount = price * (discount / 100.0);
                double finalPrice = price - discountAmount;
                total += finalPrice;
                totalDiscount += discountAmount;
                System.out.printf("%d- %s | Original: Rs.%.2f | Discount: %.1f%% | Final: Rs.%.2f\n",
                    i, totalItem.describe(), price, discount, finalPrice);
            }
            System.out.printf("Total Discount: Rs.%.2f\n", totalDiscount);
            System.out.printf("Total Bill: Rs.%.2f\n", total);
            shopTrolley.emptyTrolley();
        }
    }
    
     // Holds product details
    private static class ProductData {
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

        ProductData(String productName, int productCost, String expiryDate, String productBrand, int productType,
                    String category, int stockQuantity, double weight, double discount, double volume, String beverageExpiry) {
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
        }
    }

}
