package com.xuxiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：xuxiao
 * @date ：Created in 21/12/22 21:59
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEureKaServer7002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEureKaServer7002Application.class, args);
    }
}
