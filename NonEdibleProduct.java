/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;


/**
 * Represents a non-edible product (e.g., cleaning, personal care) with brand and safety warnings.
 * Extends StoreItem and adds non-food-specific properties.
 */
public class NonEdibleProduct extends StoreItem {
    /** Brand of the product (must not be null/empty) */
    private String productBrand;
    /** A list of safety warnings for the product */
    private String[] safetyWarnings;

    /**
     * Constructs a NonEdibleProduct with all properties.
     * Validates that productBrand is not null or empty.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product (must be >= 0)
     * @param productBrand Brand (must not be null/empty)
     * @param category Category
     * @param stockQuantity Stock available (must be >= 0)
     * @param weight Weight in grams (must be >= 0)
     * @param discount Discount percentage (0-100)
     * @param safetyWarnings A list of safety warnings
     * @throws IllegalArgumentException if productBrand is null/empty
     */
    public NonEdibleProduct(String productName, String productID, int productCost, String productBrand, String category, int stockQuantity, double weight, double discount, String[] safetyWarnings) {
        super(productName, productID, productCost, category, stockQuantity, weight, discount);
        if (productBrand == null || productBrand.isEmpty()) throw new IllegalArgumentException("Product brand cannot be null or empty.");
        this.productBrand = productBrand;
        this.safetyWarnings = safetyWarnings;
    }

    /**
     * Overloaded constructor with default discount 0.0.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product
     * @param productBrand Brand
     * @param category Category
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param safetyWarnings A list of safety warnings
     */
    public NonEdibleProduct(String productName, String productID, int productCost, String productBrand, String category, int stockQuantity, double weight, String[] safetyWarnings) {
        this(productName, productID, productCost, productBrand, category, stockQuantity, weight, 0.0, safetyWarnings);
    }


    /**
     * Gets the product brand.
     * @return Brand of the product
     */
    public String getProductBrand() {
        return productBrand;
    }


    /**
     * Sets the product brand.
     * @param productBrand Brand to set (must not be null/empty)
     * @throws IllegalArgumentException if productBrand is null/empty
     */
    public void setProductBrand(String productBrand) {
        if (productBrand == null || productBrand.isEmpty()) throw new IllegalArgumentException("Product brand cannot be null or empty.");
        this.productBrand = productBrand;
    }


    /**
     * Gets the list of safety warnings.
     * @return An array of safety warnings
     */
    public String[] getSafetyWarnings() {
        return safetyWarnings;
    }


    /**
     * Sets the list of safety warnings.
     * @param safetyWarnings An array of safety warnings
     */
    public void setSafetyWarnings(String[] safetyWarnings) {
        this.safetyWarnings = safetyWarnings;
    }


    /**
     * Indicates if the product is perishable.
     * @return false (non-edible products are not perishable)
     */
    @Override
    public boolean isPerishable() {
        return false;
    }


    /**
     * Returns a string describing the non-edible product, including brand and warnings.
     * @return Description string
     */
    @Override
    public String describe() {
        // Build a detailed description for receipts and debugging
        String description = String.format("%s (ID: %s) - Rs.%d | Brand: %s | Category: %s | Stock: %d | Weight: %.1fg | Discount: %.1f%%",
                getProductName(), getProductID(), getProductCost(), this.productBrand, getCategory(), getStockQuantity(), getWeight(), getDiscount());

        if (safetyWarnings != null && safetyWarnings.length > 0 && safetyWarnings[0] != null) {
            description += " | Warnings: " + String.join(", ", safetyWarnings);
        }
        return description;
    }
}
