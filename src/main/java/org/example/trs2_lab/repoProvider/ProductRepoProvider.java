package org.example.trs2_lab.repoProvider;

import org.example.trs2_lab.repository.base.ProductRepository;
import org.example.trs2_lab.repository.mySql.ProductRepositoryMySql;
import org.example.trs2_lab.repository.postgres.ProductRepositoryPostgres;
import org.springframework.stereotype.Component;

@Component
public class ProductRepoProvider extends AbstractRepoProvider<ProductRepository>{
    protected ProductRepoProvider(ProductRepositoryMySql mysqlRepo,
                                  ProductRepositoryPostgres postgresRepo) {
        super(mysqlRepo, postgresRepo);
    }
}
