package org.example.trs2_lab.repoProvider;

import org.example.trs2_lab.dbType.DbType;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractRepoProvider<T> {

    private final T mysqlRepo;
    private final T postgresRepo;

    protected AbstractRepoProvider(T mysqlRepo, T postgresRepo) {
        this.mysqlRepo = mysqlRepo;
        this.postgresRepo = postgresRepo;
    }

    public T getRepo(DbType dbType) {
        return dbType == DbType.MY_SQL ? mysqlRepo : postgresRepo;
    }
}
