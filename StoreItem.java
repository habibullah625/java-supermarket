/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

/**
 * Abstract base class for all products in the market.
 */
public abstract class StoreItem {
    /** Name of the product */
    private String productName;
    /** Cost of the product */
    private int productCost;
    /** Category of the product (e.g., Food, Beverage, Electronic) */
    private String category;
    /** Stock quantity available */
    private int stockQuantity;
    /** Weight in grams */
    private double weight;
    /** Discount percentage (0-100) */
    private double discount;

    /**
     * Construct a StoreItem.
     * @param productName Name of the product
     * @param productCost Cost of the product
     * @param category Category of the product
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param discount Discount percentage
     */
    public StoreItem(String productName, int productCost, String category, int stockQuantity, double weight, double discount) {
        this.productName = productName;
        this.productCost = productCost;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.weight = weight;
        this.discount = discount;
    }

    /**
     * Get product name.
     * @return Name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set product name.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get product cost.
     * @return Cost
     */
    public int getProductCost() {
        return productCost;
    }

    /**
     * Set product cost.
     */
    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    /**
     * Get category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set category.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get stock quantity.
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Set stock quantity.
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Get weight in grams.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight in grams.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get discount percentage.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Set discount percentage.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Abstract method to show product details.
     */
    public abstract String describe();

    /**
     * Abstract method to indicate if the product is perishable.
     * @return true if perishable, false otherwise
     */
    public abstract boolean isPerishable();
}
