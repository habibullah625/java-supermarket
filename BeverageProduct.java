package supermarket;


/**
 * Represents a beverage product with volume, expiry date, and carbonation status.
 * Extends StoreItem and adds beverage-specific properties.
 */
public class BeverageProduct extends StoreItem {
    /** Expiry date of the beverage (format: yyyy-MM-dd) */
    private String expiryDate;
    /** Volume in milliliters (must be >= 0) */
    private double volume;
    /** Whether the beverage is carbonated */
    private boolean isCarbonated;

    /**
     * Constructs a BeverageProduct with all properties.
     * Validates that expiryDate is not null/empty and volume is non-negative.
     *
     * @param productName Name of the product
     * @param productID A unique identifier for the product
     * @param productCost Cost of the product (must be >= 0)
     * @param expiryDate Expiry date (must not be null/empty)
     * @param category Category
     * @param stockQuantity Stock available (must be >= 0)
     * @param weight Weight in grams (must be >= 0)
     * @param discount Discount percentage (0-100)
     * @param volume Volume in milliliters (must be >= 0)
     * @param isCarbonated Whether the beverage is carbonated
     * @throws IllegalArgumentException if expiryDate is null/empty or volume is negative
     */
    public BeverageProduct(String productName, String productID, int productCost, String expiryDate, String category, int stockQuantity, double weight, double discount, double volume, boolean isCarbonated) {
        super(productName, productID, productCost, category, stockQuantity, weight, discount);
        if (expiryDate == null || expiryDate.isEmpty()) throw new IllegalArgumentException("Expiry date cannot be null or empty.");
        if (volume < 0) throw new IllegalArgumentException("Volume cannot be negative.");
        this.expiryDate = expiryDate;
        this.volume = volume;
        this.isCarbonated = isCarbonated;
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
     * @param volume Volume in milliliters
     * @param isCarbonated Whether the beverage is carbonated
     */
    public BeverageProduct(String productName, String productID, int productCost, String expiryDate, String category, int stockQuantity, double weight, double volume, boolean isCarbonated) {
        this(productName, productID, productCost, expiryDate, category, stockQuantity, weight, 0.0, volume, isCarbonated);
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
     * Gets the volume in milliliters.
     * @return Volume in milliliters
     */
    public double getVolume() {
        return volume;
    }


    /**
     * Sets the volume in milliliters. Must be >= 0.
     * @param volume Volume to set
     * @throws IllegalArgumentException if volume is negative
     */
    public void setVolume(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Volume cannot be negative.");
        this.volume = volume;
    }


    /**
     * Checks if the beverage is carbonated.
     * @return true if carbonated, false otherwise
     */
    public boolean isCarbonated() {
        return isCarbonated;
    }


    /**
     * Sets whether the beverage is carbonated.
     * @param isCarbonated true if carbonated, false otherwise
     */
    public void setCarbonated(boolean isCarbonated) {
        this.isCarbonated = isCarbonated;
    }


    /**
     * Returns a string describing the beverage product, including volume and carbonation.
     * @return Description string
     */
    @Override
    public String describe() {
        // Build a detailed description for receipts and debugging
        return String.format("%s (ID: %s) - Rs.%d | Category: %s | Stock: %d | Weight: %.1fg | Discount: %.1f%% | Volume: %.1fml | Carbonated: %s >> Expiry: %s",
                getProductName(), getProductID(), getProductCost(), getCategory(), getStockQuantity(), getWeight(), getDiscount(), volume, (isCarbonated ? "Yes" : "No"), expiryDate);
    }

    /**
     * Indicates if the product is perishable.
     * @return true (beverages are perishable)
     */
    @Override
    public boolean isPerishable() {
        return true;
    }
}
