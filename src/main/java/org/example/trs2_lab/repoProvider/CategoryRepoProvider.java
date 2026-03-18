package org.example.trs2_lab.repoProvider;

import org.example.trs2_lab.repository.base.CategoryRepository;
import org.example.trs2_lab.repository.mySql.CategoryRepositoryMySql;
import org.example.trs2_lab.repository.postgres.CategoryRepositoryPostgres;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepoProvider extends AbstractRepoProvider<CategoryRepository> {
    protected CategoryRepoProvider(CategoryRepositoryMySql mysqlRepo,
                                   CategoryRepositoryPostgres postgresRepo) {
        super(mysqlRepo, postgresRepo);
    }
}
