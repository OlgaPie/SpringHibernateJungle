package ru.junglejobs.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.junglejobs")
@PropertySource(value = {"classpath:application.properties"})
public class AppConfiguration {

    @Autowired
    @Bean(name = "flyway", initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("migration");
        flyway.setOutOfOrder(true);
        flyway.setBaselineOnMigrate(true);
        flyway.setBaselineVersionAsString("0");

        flyway.setPlaceholderPrefix("##${");
        flyway.setPlaceholderSuffix("}");

        flyway.repair();

        return flyway;
    }

}

