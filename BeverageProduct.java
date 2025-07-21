package supermarket;

/**
 * A beverage product with volume and expiry date.
 */
public class BeverageProduct extends StoreItem {
    /** Expiry date of the beverage */
    private String expiryDate;
    /** Volume in milliliters */
    private double volume;

    /**
     * Construct a BeverageProduct with all fields.
     * @param productName Name of the product
     * @param productCost Cost of the product
     * @param expiryDate Expiry date
     * @param category Category
     * @param stockQuantity Stock available
     * @param weight Weight in grams
     * @param discount Discount percentage
     * @param volume Volume in milliliters
     */
    public BeverageProduct(String productName, int productCost, String expiryDate, String category, int stockQuantity, double weight, double discount, double volume) {
        super(productName, productCost, category, stockQuantity, weight, discount);
        this.expiryDate = expiryDate;
        this.volume = volume;
    }

    /**
     * Overloaded constructor with default discount 0.0
     */
    public BeverageProduct(String productName, int productCost, String expiryDate, String category, int stockQuantity, double weight, double volume) {
        this(productName, productCost, expiryDate, category, stockQuantity, weight, 0.0, volume);
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
     * Get volume in milliliters.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Set volume in milliliters.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Show product details.
     */
    @Override
    public String describe() {
        return getProductName() + " - Rs." + getProductCost() +
                " | Category: " + getCategory() +
                " | Stock: " + getStockQuantity() +
                " | Weight: " + getWeight() + "g" +
                " | Discount: " + getDiscount() + "%" +
                " | Volume: " + volume + "ml" +
                " >> Expiry: " + expiryDate;
    }

    /**
     * Indicate if the product is perishable.
     * @return true (beverages are perishable)
     */
    @Override
    public boolean isPerishable() {
        return true;
    }
} 