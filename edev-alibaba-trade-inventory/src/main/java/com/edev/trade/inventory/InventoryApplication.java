package com.edev.trade.inventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.edev"})
@MapperScan("com.edev.support.dao")
@EnableFeignClients
public class InventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
        System.out.println(".........................................");
        System.out.println("....The Inventory Application started....");
        System.out.println(".........................................");
    }
}
