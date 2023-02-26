package com.example.answeroom.beans;

import com.example.answeroom.config.DbConfig;
import com.example.answeroom.util.App;
import kz.greetgo.conf.hot.FileConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class HotConfigFactory extends FileConfigFactory {

    @Override
    protected Path getBaseDir() {
        return App.appDir().resolve("config");
    }

    @Bean
    public DbConfig dbConfig() {
        return createConfig(DbConfig.class);
    }

}
