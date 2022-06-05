package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entity.UserDetail;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;


    @GetMapping(value = "/payment/test")
    public CommonResult getUserDetailTest(@RequestParam ("pageNum") Integer pageNum,
                                          @RequestParam ("pageSize") Integer pageSize) {
        System.out.println("---------111111111111-----------");
        System.out.println("pageNum="+pageNum);
        System.out.println("pageSize="+pageSize);
        List<?> userDetails = paymentService.queryUserDetailsList(pageNum, pageSize);
        List<UserDetail> userDetailList = (List<UserDetail>) userDetails.get(0);
        Integer total = ((List<Integer>) userDetails.get(1)).get(0);
        System.out.println("userDetailList="+userDetailList);
        System.out.println("total="+total);
        return null;
    }





    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("***********入参Payment的值为： " + payment);
        int result = paymentService.create(payment);
        log.info("***********插入结果： " + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,返回结果" + result + "\t 服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("***********入参ID的值为： " + id);
        Payment result = paymentService.getPaymentById(id);
        log.info("***********查询结果： " + result);
        if (result != null) {
            return new CommonResult(200, "查询成功" + "\t 服务端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID=" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("******element=" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println("******CLOUD-PAYMENT-SERVICE element=" + element.getServiceId() + "\t"
                    + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }


    /**
     * 构建超时响应
     * @return String
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
