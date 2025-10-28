package com.example.product.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.product.dao.ProductDAOImpl;

@Configuration
@ComponentScan("com.example.product")
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_productdb");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public ProductDAOImpl productDAO() {
        ProductDAOImpl dao = new ProductDAOImpl();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}

