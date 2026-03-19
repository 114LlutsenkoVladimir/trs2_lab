package org.example.trs2_lab.repository.mySql;

import org.example.trs2_lab.entity.Category;
import org.example.trs2_lab.repository.base.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryMySql extends CategoryRepository {
}