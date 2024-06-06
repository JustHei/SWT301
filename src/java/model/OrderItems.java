package model;

/**
 *
 * @author havie
 */
public class OrderItems {
    private int ID;
    private int orderID;
    private int productID;
    private int productPrice;
    private String productName;
    private int quantity;

    // Constructors
    public OrderItems() {
    }

    public OrderItems(int ID, int orderID, int productID, String productName, int quantity, int productPrice ) {
        this.ID = ID;
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public OrderItems(int orderID, int productID, String productName, int quantity, int productPrice) {
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice= productPrice;
    }
    
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "ID=" + ID + ", orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity + '}';
    }
    
}
