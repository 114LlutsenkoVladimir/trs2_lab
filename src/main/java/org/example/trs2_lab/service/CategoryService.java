package org.example.trs2_lab.service;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.entity.Category;
import org.example.trs2_lab.repoProvider.CategoryRepoProvider;
import org.example.trs2_lab.repository.base.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractCrudService<Category, Long,
        CategoryRepository, CategoryRepoProvider> {
    public CategoryService(CategoryRepoProvider repoProvider, DbSelectionContext dbContext) {
        super(repoProvider, dbContext);
    }
}
