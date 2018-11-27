package com.example.onlinelibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.onlinelibrary.dao","flybear.hziee.core.mybatis"})
@EnableCaching
@EnableRedisHttpSession
public class OnlinelibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinelibraryApplication.class, args);
    }

}