/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;


/**
 * Represents an edible product (food) with expiry date and allergens.
 * Extends StoreItem and adds food-specific properties.
 */
public class EdibleProduct extends StoreItem {
    /** Expiry date of the product (format: yyyy-MM-dd) */
    private String expiryDate;
    /** A list of potential allergens in the product */
    private String[] allergens;

    /**
     * Constructs an EdibleProduct with all properties.
     * Validates that expiryDate is not null or empty.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product (must be >= 0)
     * @param expiryDate Expiry date (must not be null/empty)
     * @param category Category
     * @param stockQuantity Stock available (must be >= 0)
     * @param weight Weight in grams (must be >= 0)
     * @param discount Discount percentage (0-100)
     * @param allergens A list of potential allergens
     * @throws IllegalArgumentException if expiryDate is null/empty
     */
    public EdibleProduct(String productName, String productID, int productCost, String expiryDate, String category, int stockQuantity, double weight, double discount, String[] allergens) {
        super(productName, productID, productCost, category, stockQuantity, weight, discount);
        if (expiryDate == null || expiryDate.isEmpty()) throw new IllegalArgumentException("Expiry date cannot be null or empty.");
        this.expiryDate = expiryDate;
        this.allergens = allergens;
    }

    /**
     * Overloaded constructor with default discount 0.0.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product
     * @param expiryDate Expiry date
     * @param category Category
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param allergens A list of potential allergens
     */
    public EdibleProduct(String productName, String productID, int productCost, String expiryDate, String category, int stockQuantity, double weight, String[] allergens) {
        this(productName, productID, productCost, expiryDate, category, stockQuantity, weight, 0.0, allergens);
    }


    /**
     * Gets the expiry date.
     * @return Expiry date (yyyy-MM-dd)
     */
    public String getExpiryDate() {
        return expiryDate;
    }


    /**
     * Sets the expiry date.
     * @param expiryDate Expiry date to set (must not be null/empty)
     * @throws IllegalArgumentException if expiryDate is null/empty
     */
    public void setExpiryDate(String expiryDate) {
        if (expiryDate == null || expiryDate.isEmpty()) throw new IllegalArgumentException("Expiry date cannot be null or empty.");
        this.expiryDate = expiryDate;
    }


    /**
     * Gets the list of allergens.
     * @return An array of allergens
     */
    public String[] getAllergens() {
        return allergens;
    }


    /**
     * Sets the list of allergens.
     * @param allergens An array of allergens
     */
    public void setAllergens(String[] allergens) {
        this.allergens = allergens;
    }


    /**
     * Indicates if the product is perishable.
     * @return true (edible products are perishable)
     */
    @Override
    public boolean isPerishable() {
        return true;
    }


    /**
     * Returns a string describing the edible product, including allergens and expiry.
     * @return Description string
     */
    @Override
    public String describe() {
        // Build a detailed description for receipts and debugging
        String description = String.format("%s (ID: %s) - Rs.%d | Category: %s | Stock: %d | Weight: %.1fg | Discount: %.1f%% >> Expiry: %s",
                getProductName(), getProductID(), getProductCost(), getCategory(), getStockQuantity(), getWeight(), getDiscount(), expiryDate);

        if (allergens != null && allergens.length > 0 && allergens[0] != null) {
            description += " | Allergens: " + String.join(", ", allergens);
        }
        return description;
    }
}
