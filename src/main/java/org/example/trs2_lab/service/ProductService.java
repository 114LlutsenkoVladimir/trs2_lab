package org.example.trs2_lab.service;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.entity.Product;
import org.example.trs2_lab.repoProvider.ProductRepoProvider;
import org.example.trs2_lab.repository.base.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService extends AbstractCrudService<Product, Long,
        ProductRepository, ProductRepoProvider>{

    public ProductService(ProductRepoProvider repoProvider,
                             DbSelectionContext dbContext) {
        super(repoProvider, dbContext);
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return currentRepo().findByCategoryId(categoryId);
    }

    public List<Product> findByManufacturerId(Long manufacturerId) {
        return currentRepo().findByManufacturerId(manufacturerId);
    }

    public List<Product> findByPriceBetween(BigDecimal start, BigDecimal end) {
        return currentRepo().findByPriceBetween(start, end);
    }
}
