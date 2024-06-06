package model;

/**
 *
 * @author havie
 */
public class Products {

    private int ID;
    private String name;
    private String description;
    private int price;
    private String image;
    private int categoryID;
    private int quantity;

    // Constructors
    public Products() {
    }

    public Products(String name, String description, int price, String image, int categoryID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
    }

    public Products(int ID, String name, String description, int price, String image, int categoryID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
    }

    public Products(int ID, String name, String description, int price, String image, int categoryID, int quantity) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

    public Products(String name, String description, int price, String image, int categoryID, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    // Getters and setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
