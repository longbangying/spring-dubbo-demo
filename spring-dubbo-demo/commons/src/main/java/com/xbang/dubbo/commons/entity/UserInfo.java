package com.xbang.dubbo.commons.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private String userId;

    private String userName;

    private int age;

    private String address;

}
