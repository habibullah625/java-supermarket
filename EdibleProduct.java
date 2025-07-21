/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

/**
 * A food product with expiry date.
 */
public class EdibleProduct extends StoreItem{
    /** Expiry date of the product */
    private String expiryDate;

    /**
     * Make food product.
     * @param productName Name of the product
     * @param productCost Cost of the product
     * @param expiryDate Expiry date
     * @param category Category
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param discount Discount percentage
     */
    public EdibleProduct(String productName, int productCost, String expiryDate, String category, int stockQuantity, double weight, double discount) {
        super(productName, productCost, category, stockQuantity, weight, discount);
        this.expiryDate = expiryDate;
    }
    
    /**
     * Overloaded constructor with default discount 0.0
     */
    public EdibleProduct(String productName, int productCost, String expiryDate, String category, int stockQuantity, double weight) {
        this(productName, productCost, expiryDate, category, stockQuantity, weight, 0.0);
    }

    /**
     * Get expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set expiry date.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Indicate if the product is perishable.
     * @return true (edible products are perishable)
     */
    @Override
    public boolean isPerishable() {
        return true;
    }

    /**
     * Show product details.
     */
    @Override
    public String describe(){
        return getProductName() + " - Rs." + getProductCost() +
                " | Category: " + getCategory() +
                " | Stock: " + getStockQuantity() +
                " | Weight: " + getWeight() + "g" +
                " | Discount: " + getDiscount() + "%" +
                " >> Expiry: " + expiryDate;
    }
}
