package com.chen.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable{
    private int id;
    private String username;
    private String jobs;
    private String phone;
}
