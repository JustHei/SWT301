package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.Orders;

public class OrdersDAO extends MyDAO {

    private static final Logger logger = Logger.getLogger(OrdersDAO.class.getName());

    // lay ra nhung don hang cua 1 khach hang
    public List<Orders> getOrderByUserID(int userID) {
        List<Orders> orderList = new ArrayList<>();
        String xSql = "SELECT o.*, u.username, os.status_name FROM Orders o\n"
                + "join Users u on o.UserID = u.ID\n"
                + "join OrderStatus os on o.StatusID = os.orderstatus_id \n"
                + "WHERE UserID = ?;";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setInt(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    LocalDate orderDate = rs.getDate("OrderDate").toLocalDate();
                    int totalAmount = rs.getInt("TotalAmount");
                    int StatusID = rs.getInt("StatusID");
                    String username = rs.getString("username");
                    String statusName = rs.getString("status_name");
                    Orders order = new Orders(id, userID, name, phoneNumber, address, orderDate, totalAmount, StatusID, username, statusName);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error getting orders by user ID", e);
        }
        return orderList;
    }

    public Orders getOrderByOdId(int odid) {
        Orders order = null;
        String sql = "SELECT o.*, u.username, os.status_name FROM Orders o\n"
                + "join Users u on o.UserID = u.ID\n"
                + "join OrderStatus os on o.StatusID = os.orderstatus_id \n"
                + "WHERE o.ID = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, odid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    LocalDate orderDate = rs.getDate("OrderDate").toLocalDate();
                    int totalAmount = rs.getInt("TotalAmount");
                    int statusID = rs.getInt("StatusID");
                    String username = rs.getString("username");
                    String statusName = rs.getString("status_name");
                    order = new Orders(id, userID, name, phoneNumber, address, orderDate, totalAmount, statusID, username, statusName);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error getting order by order ID", e);
        }
        return order;
    }

    // lay ra tat ca nhung don hang
    public List<Orders> getAllOrders() {
        List<Orders> orderList = new ArrayList<>();
        String xSql = "SELECT o.*, u.username, os.status_name FROM Orders o\n"
                + "join Users u on o.UserID = u.ID\n"
                + "join OrderStatus os on o.StatusID = os.orderstatus_id ";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(xSql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                int userID = rs.getInt("UserID");
                String name = rs.getString("Name");
                String phoneNumber = rs.getString("phonenumber");
                String address = rs.getString("Address");
                LocalDate orderDate = rs.getDate("OrderDate").toLocalDate();
                int totalAmount = rs.getInt("TotalAmount");
                int StatusID = rs.getInt("StatusID");
                String username = rs.getString("username");
                String statusName = rs.getString("status_name");
                Orders order = new Orders(id, userID, name, phoneNumber, address, orderDate, totalAmount, StatusID, username, statusName);
                orderList.add(order);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error getting all orders", e);
        }
        return orderList;
    }

    // tao 1 don hàng
    public void createOrder(Orders order) {
        String xSql = "INSERT INTO Orders (UserID, Name, phonenumber, Address, OrderDate, TotalAmount, StatusID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(xSql)) {
            ps.setInt(1, order.getUserID());
            ps.setString(2, order.getName());
            ps.setString(3, order.getPhone());
            ps.setString(4, order.getAddress());
            ps.setDate(5, Date.valueOf(order.getOrderDate()));
            ps.setInt(6, order.getTotalAmount());
            ps.setInt(7, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating order", e);
        }
    }

    public void nextStatus(int orderId) {
        try (Connection con = getConnection()) {
            // Tìm `StatusID` hiện tại của đơn hàng
            String getStatusSql = "SELECT StatusID FROM Orders WHERE ID = ?";
            try (PreparedStatement ps = con.prepareStatement(getStatusSql)) {
                ps.setInt(1, orderId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int currentStatus = rs.getInt("StatusID");
                        if (currentStatus < 3) {
                            // Chỉ tăng `StatusID` nếu nó nhỏ hơn 3
                            int newStatus = currentStatus + 1;
                            // Cập nhật `StatusID`
                            String updateStatusSql = "UPDATE Orders SET StatusID = ? WHERE ID = ?";
                            try (PreparedStatement updatePs = con.prepareStatement(updateStatusSql)) {
                                updatePs.setInt(1, newStatus);
                                updatePs.setInt(2, orderId);
                                updatePs.executeUpdate();
                            }
                        } else {
                            // Đã đạt đến trạng thái tối đa
                            // Có thể xử lý hoặc thông báo tùy theo nhu cầu
                        }
                    } else {
                        // Không tìm thấy đơn hàng với ID tương ứng
                        // Xử lý lỗi hoặc thông báo
                        logger.log(Level.WARNING, "Order not found with ID: " + orderId);
                    }
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating order status", e);
        }
    }

    public static class MainClass {
        public static void main(String[] args) {
            OrdersDAO od = new OrdersDAO();
            logger.log(Level.INFO, od.getAllOrders().toString());
        }
    }
}
