/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

/**
 * A non-food product with brand.
 */
public class NonEdibleProduct extends StoreItem{
    /** Brand of the product */
    private String productBrand;

    /**
     * Make non-food product.
     * @param productName Name of the product
     * @param productCost Cost of the product
     * @param productBrand Brand
     * @param category Category
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param discount Discount percentage
     */
    public NonEdibleProduct(String productName, int productCost, String productBrand, String category, int stockQuantity, double weight, double discount) {
        super(productName, productCost, category, stockQuantity, weight, discount);
        this.productBrand = productBrand;
    }
    
    /**
     * Overloaded constructor with default discount 0.0
     */
    public NonEdibleProduct(String productName, int productCost, String productBrand, String category, int stockQuantity, double weight) {
        this(productName, productCost, productBrand, category, stockQuantity, weight, 0.0);
    }

    /**
     * Get product brand.
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * Set product brand.
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * Indicate if the product is perishable.
     * @return false (non-edible products are not perishable)
     */
    @Override
    public boolean isPerishable() {
        return false;
    }

    /**
     * Show product Details.
     */
    @Override
    public String describe(){
        return getProductName() + " - Rs." + getProductCost() +
                " | Category: " + getCategory() +
                " | Stock: " + getStockQuantity() +
                " | Weight: " + getWeight() + "g" +
                " | Discount: " + getDiscount() + "%" +
                " >> Brand: " + productBrand;
    }
}
