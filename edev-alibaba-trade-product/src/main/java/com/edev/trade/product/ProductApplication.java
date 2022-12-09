package com.edev.trade.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.edev"})
@MapperScan("com.edev.support.dao")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
        System.out.println(".......................................");
        System.out.println("....The Product Application started....");
        System.out.println(".......................................");
    }
}
