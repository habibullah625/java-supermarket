/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;


/**
 * Abstract base class for all products in the supermarket.
 * <p>
 * This class defines the common properties and behaviors for all store items.
 * It enforces encapsulation and provides validation to ensure data integrity.
 * Subclasses must implement describe() and isPerishable().
 */
public abstract class StoreItem {
    /** Name of the product */
    private String productName;
    /** A unique identifier for the product (e.g., SKU) */
    private String productID;
    /** Cost of the product (must be >= 0) */
    private int productCost;
    /** Category of the product (e.g., Food, Beverage, Electronic) */
    private String category;
    /** Stock quantity available (must be >= 0) */
    private int stockQuantity;
    /** Weight in grams (must be >= 0) */
    private double weight;
    /** Discount percentage (0-100) */
    private double discount;

    /**
     * Constructs a StoreItem with validation.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product (must be >= 0)
     * @param category Category of the product
     * @param stockQuantity Stock available (must be >= 0)
     * @param weight Weight in grams (must be >= 0)
     * @param discount Discount percentage (0-100)
     * @throws IllegalArgumentException if any value is invalid
     */
    public StoreItem(String productName, String productID, int productCost, String category, int stockQuantity, double weight, double discount) {
        if (productCost < 0) throw new IllegalArgumentException("Product cost cannot be negative.");
        if (stockQuantity < 0) throw new IllegalArgumentException("Stock quantity cannot be negative.");
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative.");
        if (discount < 0 || discount > 100) throw new IllegalArgumentException("Discount must be between 0 and 100.");
        this.productName = productName;
        this.productID = productID;
        this.productCost = productCost;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.weight = weight;
        this.discount = discount;
    }


    /**
     * Gets the product name.
     * @return Name of the product
     */
    public String getProductName() {
        return productName;
    }


    /**
     * Sets the product name.
     * @param productName Name to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }


    /**
     * Gets the unique product identifier.
     * @return The product ID
     */
    public String getProductID() {
        return productID;
    }


    /**
     * Sets the unique product identifier.
     * @param productID The new product ID
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }


    /**
     * Gets the product cost.
     * @return Cost of the product
     */
    public int getProductCost() {
        return productCost;
    }


    /**
     * Sets the product cost. Must be >= 0.
     * @param productCost Cost to set
     * @throws IllegalArgumentException if productCost is negative
     */
    public void setProductCost(int productCost) {
        if (productCost < 0) throw new IllegalArgumentException("Product cost cannot be negative.");
        this.productCost = productCost;
    }


    /**
     * Gets the product category.
     * @return Category of the product
     */
    public String getCategory() {
        return category;
    }


    /**
     * Sets the product category.
     * @param category Category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * Gets the stock quantity.
     * @return Stock quantity available
     */
    public int getStockQuantity() {
        return stockQuantity;
    }


    /**
     * Sets the stock quantity. Must be >= 0.
     * @param stockQuantity Stock quantity to set
     * @throws IllegalArgumentException if stockQuantity is negative
     */
    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) throw new IllegalArgumentException("Stock quantity cannot be negative.");
        this.stockQuantity = stockQuantity;
    }


    /**
     * Gets the weight in grams.
     * @return Weight in grams
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Sets the weight in grams. Must be >= 0.
     * @param weight Weight to set
     * @throws IllegalArgumentException if weight is negative
     */
    public void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative.");
        this.weight = weight;
    }


    /**
     * Gets the discount percentage.
     * @return Discount percentage (0-100)
     */
    public double getDiscount() {
        return discount;
    }


    /**
     * Sets the discount percentage. Must be between 0 and 100.
     * @param discount Discount to set
     * @throws IllegalArgumentException if discount is out of range
     */
    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100) throw new IllegalArgumentException("Discount must be between 0 and 100.");
        this.discount = discount;
    }


    /**
     * Returns a string describing the product, including all key properties.
     * Subclasses should override to provide more details.
     * @return Description string
     */
    public abstract String describe();

    /**
     * Indicates if the product is perishable (e.g., food, beverage).
     * Subclasses must implement this to specify perishable status.
     * @return true if perishable, false otherwise
     */
    public abstract boolean isPerishable();
}
