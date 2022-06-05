package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    /**
     *  使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced  // 注释掉后如果还有负载均衡效果，表明自定义的负载均衡com.atguigu.springcloud.lb.impl.MyLB生效了
     public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
