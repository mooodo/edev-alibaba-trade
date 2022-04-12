package com.edev.trade.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.edev"})
@ImportResource(locations={"classpath*:applicationContext-*.xml"})
@MapperScan("com.edev.support.dao")
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
        System.out.println("........................................");
        System.out.println("....The Customer Application started....");
        System.out.println("........................................");
    }
}
