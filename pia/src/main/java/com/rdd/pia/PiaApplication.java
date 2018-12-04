package com.rdd.pia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author mic
 */

@MapperScan(basePackages = "com.rdd")
@SpringBootApplication
public class PiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiaApplication.class, args);
	}
}
