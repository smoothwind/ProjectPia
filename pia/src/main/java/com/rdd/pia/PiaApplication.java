package com.rdd.pia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mic
 */

@MapperScan(basePackages = "com.rdd") //自动扫描mapper
@ComponentScan(basePackages = "com.rdd") //自动扫描bean
@SpringBootApplication
public class PiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiaApplication.class, args);
	}
}
