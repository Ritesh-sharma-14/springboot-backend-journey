import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ProductDAO {
    private JdbcTemplate jdbcTemplate;

    // Setter injection from XML config
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert
    public int save(Product p) {
        String sql = "INSERT INTO products(name, price) VALUES (?, ?)";
        return jdbcTemplate.update(sql, p.getName(), p.getPrice());
    }

    // Update
    public int update(Product p) {
        String sql = "UPDATE products SET name=?, price=? WHERE id=?";
        return jdbcTemplate.update(sql, p.getName(), p.getPrice(), p.getId());
    }

    // Delete
    public int delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    // Get single product
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}

