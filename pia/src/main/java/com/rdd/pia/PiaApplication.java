package com.rdd.pia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * lalalalalla
 * @author mic
 */

@ComponentScan(basePackages = "com.rdd.pia.model") //自动扫描bean
@EnableJpaRepositories(basePackages = "com.rdd.pia.repositories")/* 启动JPA */
@SpringBootApplication
public class PiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiaApplication.class, args);
	}
}
