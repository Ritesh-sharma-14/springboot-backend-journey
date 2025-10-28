package com.example.product.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.example.product.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private JdbcTemplate jdbcTemplate;

    // Setter injection
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addProduct(Product product) {
        String sql = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getPrice());
    }

    @Override
    public int updateProduct(Product product) {
        String sql = "UPDATE products SET name=?, category=?, price=? WHERE id=?";
        return jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getPrice(), product.getId());
    }

    @Override
    public int deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id=?";
        RowMapper<Product> mapper = (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setCategory(rs.getString("category"));
            p.setPrice(rs.getDouble("price"));
            return p;
        };
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setCategory(rs.getString("category"));
            p.setPrice(rs.getDouble("price"));
            return p;
        });
    }
}

