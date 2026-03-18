package org.example.trs2_lab.repository.base;

import org.example.trs2_lab.entity.Category;
import org.example.trs2_lab.entity.Manufacturer;
import org.example.trs2_lab.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByManufacturerId(Long manufacturerId);

    List<Product> findByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);


}