package com.example.answeroom.beans;

import com.example.answeroom.config.DbConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class DatasourceBean {

  private final DbConfig dbConfig;

  @Bean
  public DataSource dataSource() {
    var url = "jdbc:postgresql://" + dbConfig.host() + ":" + dbConfig.port() + "/" + dbConfig.dbName();

    var config = new HikariConfig();

    config.setDriverClassName("org.postgresql.Driver");
    config.setJdbcUrl(url);
    config.setUsername(dbConfig.username());
    config.setPassword(dbConfig.password());
    config.setMaximumPoolSize(200);

    return new HikariDataSource(config);
  }

}
