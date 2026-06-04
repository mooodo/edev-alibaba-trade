package com.edev.auth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.edev")
@MapperScan("com.edev.support.dao")
public class AuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApplication.class, args);
        System.out.println(".........................................");
        System.out.println("....The Authority Application started....");
        System.out.println(".........................................");
    }
}
