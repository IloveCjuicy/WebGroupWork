package com.example.experimentchapter45;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.experimentchapter45.Mapper")
public class ExperimentChapter45Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(ExperimentChapter45Application.class, args);
    }
}
