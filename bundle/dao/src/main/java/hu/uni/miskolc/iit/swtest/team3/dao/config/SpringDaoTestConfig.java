package hu.uni.miskolc.iit.swtest.team3.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class SpringDaoTestConfig extends SpringDaoConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/softwaretesting_test");
        dataSource.setUsername("softwaretesting");
        dataSource.setPassword("softwaretesting");
        return dataSource;
    }

}
