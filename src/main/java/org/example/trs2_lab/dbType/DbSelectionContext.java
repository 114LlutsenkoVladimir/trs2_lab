package org.example.trs2_lab.dbType;

import org.springframework.stereotype.Component;

@Component
public class DbSelectionContext {
    private DbType currentDbType = DbType.MY_SQL;

    public DbType getCurrentDbType() {
        return currentDbType;
    }

    public void setCurrentDbType(DbType currentDbType) {
        this.currentDbType = currentDbType;
    }
}
