package com.revature.mtbbros.daos;

import com.revature.mtbbros.models.Product;
import com.revature.mtbbros.util.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements CrudDAO<Product> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Product obj) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into product (product_id,product_name,brand,description,price,on_hand) values (?, ?, ? ,?, ?, ?)");
            ps.setString(1, obj.getProductId());
            ps.setString(2, obj.getProductName());
            ps.setString(3, obj.getBrand());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getPrice());
            ps.setString(6, obj.getOnHand());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
