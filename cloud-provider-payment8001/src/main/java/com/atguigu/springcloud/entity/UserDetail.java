package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：xuxiao
 * @date ：Created in 22/2/21 20:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    private String id;
    private String nickName;
    private String password;
    private String trueName;
    private String phone;
    private Integer locked;


}
