package org.example.trs2_lab.controller;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.dbType.DbType;
import org.springframework.ui.Model;

import java.util.List;

public class AbstractDbContextController<T> {
    protected DbSelectionContext dbContext;
    protected String mySqlTableName;
    protected String postgresqlTableName;

    public AbstractDbContextController(DbSelectionContext dbContext,
                                       String mySqlTableName,
                                       String postgresqlTableName) {
        this.dbContext = dbContext;
        this.mySqlTableName = mySqlTableName;
        this.postgresqlTableName = postgresqlTableName;
    }

    public void updateRelevantTable(List<T> entityList, Model model) {
        DbType type = dbContext.getCurrentDbType();
        if(type == DbType.MY_SQL)
            model.addAttribute(mySqlTableName, entityList);
        else
            model.addAttribute(postgresqlTableName, entityList);
    }
}
