package data;

import org.flywaydb.core.Flyway;
import prefs.Prefs;

public class DatabaseInitServiceFlyway {
    public void initDb(){
        String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        flyway.migrate();
    }
}
