package pharmacy.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class SingletonDataSource {

    private static final SingletonDataSource instance = new SingletonDataSource();

    private DataSource dataSource;

    private SingletonDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/pharmacy_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");

        this.dataSource = dataSource;
    }

    public static SingletonDataSource getInstance() {
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}

