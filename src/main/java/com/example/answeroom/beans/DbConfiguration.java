package com.example.answeroom.beans;

import com.example.answeroom.dao.BeanConfigDao;
import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@MapperScan(basePackageClasses = BeanConfigDao.class)
public class DbConfiguration {

    private final DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() {
        var liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    public IdGenerator idGenerator() {
        return new AlternativeJdkIdGenerator();
    }

}
