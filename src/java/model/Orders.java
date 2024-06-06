package model;

/**
 *
 * @author havie
 */
import java.time.LocalDate;
import java.util.Date;

public class Orders {

    private int ID;
    private int userID;
    private String name;
    private String phone;
    private String address;
    private LocalDate orderDate;
    private int totalAmount;
    private int status;
    private String username;
    private String statusName;

    // Constructors
    public Orders() {
    }

    public Orders(int ID, int userID, String name, String phone, String address, LocalDate orderDate, int totalAmount, int status,String username, String statusName) {
        this.ID = ID;
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.username = username;
        this.statusName = statusName;
    }

    public Orders(int userID, String name, String phone, String address, LocalDate orderDate, int totalAmount) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    
    
    
    @Override
    public String toString() {
        return "Orders{" + "ID=" + ID + ", userID=" + userID + ", name=" + name + ", phone=" + phone + ", address=" + address + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + '}';
    }

}
