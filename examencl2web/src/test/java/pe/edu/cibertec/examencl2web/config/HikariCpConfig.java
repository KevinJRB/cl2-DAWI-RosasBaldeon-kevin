package pe.edu.cibertec.examencl2web.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {
    @Value("${DB_WORLD_URL}")
    private String dbSakilaUrl;
    @Value("${DB_WORLD_USER}")
    private String dbSakilaUser;
    @Value("${DB_WORLD_PASS}")
    private String dbSakilaPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbSakilaDriver;
    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();


        config.setJdbcUrl(dbSakilaUrl);
        config.setUsername(dbSakilaUser);
        config.setPassword(dbSakilaPass);
        config.setDriverClassName(dbSakilaDriver);


        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);

    }
}
