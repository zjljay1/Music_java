package com.music.music_java.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/*
* mybatis 配置类
* */
@Configuration
@MapperScan("com.music.music_java.mapper")
public class MybatisConfig {

}
