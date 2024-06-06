package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Products;

public class ProductsDAO extends MyDAO {
    
    //lay ra danh sách tat ca san pham
    public List<Products> getAllProducts() {
        List<Products> productList = new ArrayList<>();
        xSql = "SELECT * FROM Products";
        try {
            int id, price, categoryID;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                categoryID = rs.getInt("CategoryID");
                Products p = new Products(id, name, description, price, image, categoryID);
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    // lay ra san pham theo category
    public List<Products> getProductsByCategoryID(int categoryID) {
        List<Products> productList = new ArrayList<>();
        xSql = "SELECT * FROM Products WHERE CategoryID = ?";
        try {
            int id, price;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                product = new Products(id, name, description, price, image, categoryID);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    // lay san pham bang id
    public Products getProductByID(int productID) {
        xSql = "SELECT * FROM Products WHERE ID = ?";
        try {
            int id, price, categoryID;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                categoryID = rs.getInt("CategoryID");
                product = new Products(id, name, description, price, image, categoryID);
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // hàm search san pham
    public List<Products> searchProductByName(String text) {
        List<Products> productList = new ArrayList<>();
        xSql = "SELECT * FROM Products WHERE Name LIKE ?";
        try {
            int id, price, sellerID, categoryID;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + text + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                categoryID = rs.getInt("CategoryID");
                product = new Products(id, name, description, price, image, categoryID);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    // hàm thêm moi 1 san pham
    public void addProduct(Products product) {
        xSql = "INSERT INTO Products (Name, Description, Price, Image, CategoryID) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getCategoryID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // hàm sua san pham
    public void editProduct(int productID, Products updatedProduct) {
        xSql = "UPDATE Products SET Name = ?, Description = ?, Price = ?, Image = ?, CategoryID = ? WHERE ID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, updatedProduct.getName());
            ps.setString(2, updatedProduct.getDescription());
            ps.setInt(3, updatedProduct.getPrice());
            ps.setString(4, updatedProduct.getImage());
            ps.setInt(5, updatedProduct.getCategoryID());
            ps.setInt(6, productID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // hàm xóa san pham
    public void deleteProduct(int productID) {
        try {
            // Cập nhật các mặt hàng liên quan trong bảng OrderItems, đặt ProductID thành null
            String updateOrderItemsSql = "UPDATE OrderItems SET ProductID = null WHERE ProductID = ?";
            PreparedStatement updateOrderItemsPs = con.prepareStatement(updateOrderItemsSql);
            updateOrderItemsPs.setInt(1, productID);
            updateOrderItemsPs.executeUpdate();

            // Xóa sản phẩm từ bảng Products
            String deleteProductSql = "DELETE FROM Products WHERE ID = ?";
            PreparedStatement deleteProductPs = con.prepareStatement(deleteProductSql);
            deleteProductPs.setInt(1, productID);
            deleteProductPs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
