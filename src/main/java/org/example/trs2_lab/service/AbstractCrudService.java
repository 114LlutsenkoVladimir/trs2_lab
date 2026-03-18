package org.example.trs2_lab.service;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.repoProvider.AbstractRepoProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public class AbstractCrudService<T, ID,
        RP extends JpaRepository<T, ID>,
        RPP extends AbstractRepoProvider<RP>> {

    protected final RPP repoProvider;
    protected final DbSelectionContext dbContext;


    protected AbstractCrudService(RPP repoProvider,
                                  DbSelectionContext dbContext) {
        this.repoProvider = repoProvider;
        this.dbContext = dbContext;
    }

    public RP currentContextRepo() {
        return repoProvider.getRepo(dbContext.getCurrentDbType());
    }

    public void create(T entity) {
        currentContextRepo().save(entity);
    }

    public Optional<T> findById(ID id) {
        return currentContextRepo().findById(id);
    }

    public List<T> findAll() {
        return currentContextRepo().findAll();
    }

    public T update(T entity) {
        return currentContextRepo().save(entity);
    }

    public void delete(ID id) {
        currentContextRepo().deleteById(id);
    }


}
