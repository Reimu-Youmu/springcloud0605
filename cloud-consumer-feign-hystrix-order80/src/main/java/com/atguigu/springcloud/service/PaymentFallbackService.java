package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author ：xuxiao
 * @date ：Created in 21/12/30 23:24
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "[PaymentFallbackService][paymentInfo_OK]调用微服务CLOUD-PROVIDER-HYSTRIX-PAYMENT失败..................";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "[PaymentFallbackService][paymentInfo_TimeOut]调用微服务CLOUD-PROVIDER-HYSTRIX-PAYMENT失败 ..................";
    }
}
