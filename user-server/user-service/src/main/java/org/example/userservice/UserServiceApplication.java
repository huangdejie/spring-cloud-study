package org.example.userservice;

import org.example.userservice.importBeanDefinitionRegistrardemo.DJRegistra;
import org.example.userservice.importBeanDefinitionRegistrardemo.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@DJRegistra
@EnableFeignClients(basePackages = "org.example.clients")
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
        System.out.println(context.getBean(DemoService.class));
    }

}
