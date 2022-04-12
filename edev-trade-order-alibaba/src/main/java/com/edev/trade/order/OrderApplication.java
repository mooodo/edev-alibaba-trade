package com.edev.trade.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.edev"})
@ImportResource(locations={"classpath*:applicationContext-*.xml"})
@MapperScan("com.edev.support.dao")
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        System.out.println(".....................................");
        System.out.println("....The Order Application started....");
        System.out.println(".....................................");
    }
}
