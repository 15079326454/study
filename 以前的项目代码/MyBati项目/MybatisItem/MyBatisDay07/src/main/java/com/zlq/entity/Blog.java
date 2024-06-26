package com.zlq.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Blog {
    private String id;

    private String title;

    private String author;

    private Date createTime;

    private Integer views;

}