# Supermarket Java Project

## Project Overview
This project is a menu-driven supermarket application that allows users to buy, view, and remove products from a shopping trolley. It demonstrates strong object-oriented design, encapsulation, modularity, and includes advanced features such as live inventory management and out-of-stock handling.

---

## Features & Teacher Feedback Alignment

### 1. Minimum Custom-Built Classes, Inheritance, Overriding/Overloading
- **Abstract class:** `StoreItem` is abstract and forms the base for all products.
- **Inheritance:** `EdibleProduct`, `NonEdibleProduct`, and `BeverageProduct` extend `StoreItem`.
- **Overridden/Overloaded Methods:** All subclasses override `describe()` and `isPerishable()`. Overloaded constructors are present in all subclasses.

### 2. Properties, Encapsulation, Commenting
- **Encapsulation:** All fields are private with public getters/setters.
- **Properties:**
  - `StoreItem`: `productID`, `productName`, `productCost`, `category`, `stockQuantity`, `weight`, `discount`
  - `EdibleProduct`: `expiryDate`, `allergens`
  - `NonEdibleProduct`: `productBrand`, `safetyWarnings`
  - `BeverageProduct`: `expiryDate`, `volume`, `isCarbonated`
- **Commenting:** All classes and methods have JavaDoc comments explaining their purpose, parameters, and return values.

### 3. Code Modularity, Commenting, GitHub Activity
- **Modular Methods:** Large methods are split into helpers (e.g., `addToTrolley`, `addProductsToTrolley`, `viewEditTrolley`).
- **No `while(true)` in main loop:** Main loop uses a boolean flag for control.
- **Commenting:** JavaDoc comments are present and explain logic.

### 4. Program Execution
- The menu displays all products, stock, and out-of-stock status.
- Users can add and remove items from the trolley.
- The program prevents adding out-of-stock items.
- The receipt is printed with all details.
- No linkage errors; the JAR runs as expected.

### 5. EXTRA CHALLENGE
- **Remove items from trolley:** `View/Edit Trolley` menu option allows users to view and remove items.
- **Live inventory management:** Stock decreases when items are added to the trolley, increases when removed.
- **Out-of-stock handling:** Menu shows `[OUT OF STOCK]` for items with zero stock. User cannot add out-of-stock items to trolley and receives a message.
- **Enhanced receipt:** Receipt shows all product details, including IDs, allergens, warnings, and discounts.

---

## How to Compile and Run the Project

### 1. Open your terminal
Navigate to your project directory:
```
cd C:\Users\IC\Downloads\Habibullah\Habibullah\supermarket\java-supermarket
cd C:\java-supermarket
```

### 2. Compile all Java files
This command compiles all `.java` files and puts the `.class` files in the correct package structure:
```
javac -d . *.java
```

### 3. Create the JAR file
This command packages all compiled classes into an executable JAR, specifying the main class:
```
jar cfe SupermarketApp.jar supermarket.Supermarket supermarket/*.class
```
- `SupermarketApp.jar` is the name of your JAR file.
- `supermarket.Supermarket` is the main class (with the main method).
- `supermarket/*.class` includes all compiled classes in the supermarket package.

### 4. Run the JAR file
This command runs your application:
```
java -jar SupermarketApp.jar
```

---

## Summary Table (Feedback Alignment)

| Criteria | What You’ve Done (with Proof) |
|----------|-------------------------------|
| OOP Structure, Inheritance, Overriding | Abstract class, subclasses, overridden/overloaded methods (`StoreItem`, `EdibleProduct`, etc.) |
| Properties, Encapsulation, Commenting | Many properties, all private, JavaDoc comments |
| Modularity, Commenting, GitHub | Modular methods, no `while(true)`, JavaDoc comments |
| Program Execution | JAR runs, menu works, receipt prints with new properties |
| Extra Challenge | Remove from trolley, live inventory, out-of-stock handling, enhanced receipt |

---

## Project Authors
- Habibullah

---