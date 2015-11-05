package com.fpmislata.banco_api.presentation.database;

import com.fpmislata.banco_service.persistence.jdbc.DataSourceFactory;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class MigrationDBImpl implements MigrationDB {

    @Autowired
    private DataSourceFactory dataSourceFactory;

    @Override
    public void toMigration() {
        try {
            DataSource dataSource = dataSourceFactory.getDataSource();
            Flyway flyway = new Flyway();
            flyway.setDataSource(dataSource);
            flyway.setLocations("com.fpmislata.banco_service.persistence.scripts");
            flyway.setEncoding("utf-8");
            flyway.migrate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
