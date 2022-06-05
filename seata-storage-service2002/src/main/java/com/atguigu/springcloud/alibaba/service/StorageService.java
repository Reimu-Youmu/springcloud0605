package com.atguigu.springcloud.alibaba.service;

/**
 * @author ：xuxiao
 * @date ：Created in 22/1/14 22:30
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
