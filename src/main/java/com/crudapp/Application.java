package com.crudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Autowired JdbcTemplate jdbc;
    // アプリ起動時に実行される。
    @Override
    public void run(String... args) throws Exception {
        jdbc.execute("create table task (id serial, name varchar(255))");
        jdbc.update("insert into task (name) values (?)", "First Task.");
    }
    */
}