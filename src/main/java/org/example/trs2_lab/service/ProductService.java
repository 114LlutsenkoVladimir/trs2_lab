package org.example.trs2_lab.service;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.entity.Product;
import org.example.trs2_lab.repoProvider.ProductRepoProvider;
import org.example.trs2_lab.repository.base.ProductRepository;
import org.springframework.stereotype.Service;

@Service
class ProductService extends AbstractCrudService<Product, Long,
        ProductRepository, ProductRepoProvider>{

    public ProductService(ProductRepoProvider repoProvider,
                             DbSelectionContext dbContext) {
        super(repoProvider, dbContext);
    }
}
