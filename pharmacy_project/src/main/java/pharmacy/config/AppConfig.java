package pharmacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("pharmacy")
public class AppConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(SingletonDataSource.getInstance().getDataSource());
    }

}
