package com.atguigu.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @author ：xuxiao
 * @date ：Created in 22/1/14 22:28
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
