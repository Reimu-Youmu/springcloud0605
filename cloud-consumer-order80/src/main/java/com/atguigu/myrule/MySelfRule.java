package com.atguigu.myrule;

/**
 * @author ：xuxiao
 * @date ：Created in 21/12/26 22:23
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon自定义算法不能被spring boot扫描到
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        return  new RandomRule();//定义为随机
        //return new RoundRobinRule(); // 轮询
        //return new RetryRule(); // 重试
        //return new WeightedResponseTimeRule(); //
        //return new BestAvailableRule(); //
        //return new AvailabilityFilteringRule(); //
        //return new ZoneAvoidanceRule(); //

    }
}
