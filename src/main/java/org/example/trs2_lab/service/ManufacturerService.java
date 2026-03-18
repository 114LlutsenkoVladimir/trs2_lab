package org.example.trs2_lab.service;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.entity.Manufacturer;
import org.example.trs2_lab.repoProvider.ManufacturerRepoProvider;
import org.example.trs2_lab.repository.base.ManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService extends AbstractCrudService<Manufacturer, Long,
        ManufacturerRepository, ManufacturerRepoProvider> {
    public ManufacturerService(ManufacturerRepoProvider repoProvider, DbSelectionContext dbContext) {
        super(repoProvider, dbContext);
    }
}
