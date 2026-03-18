package org.example.trs2_lab.repoProvider;

import org.example.trs2_lab.repository.base.ManufacturerRepository;
import org.example.trs2_lab.repository.mySql.ManufacturerRepositoryMySql;
import org.example.trs2_lab.repository.postgres.ManufacturerRepositoryPostgres;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerRepoProvider extends AbstractRepoProvider<ManufacturerRepository> {
    protected ManufacturerRepoProvider(ManufacturerRepositoryMySql mysqlRepo,
                                       ManufacturerRepositoryPostgres postgresRepo) {
        super(mysqlRepo, postgresRepo);
    }
}
