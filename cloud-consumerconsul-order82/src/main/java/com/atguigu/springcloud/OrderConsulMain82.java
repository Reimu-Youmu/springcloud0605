package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：xuxiao
 * @date ：Created in 21/12/25 21:49
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderConsulMain82 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderConsulMain82.class,args);
    }
}
