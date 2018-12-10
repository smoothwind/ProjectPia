package com.rdd.pia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * lalalalalla
 * @author mic
 */
@MapperScan(basePackages = "com.rdd") //自动扫描mapper
@ComponentScan(basePackages = "com") //自动扫描bean
@EnableJpaRepositories(basePackages = "com.rdd.pia.repositories")/* 启动JPA */
@EntityScan(basePackages="com.rdd.pia.model")
@SpringBootApplication
public class PiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiaApplication.class, args);
	}
}
