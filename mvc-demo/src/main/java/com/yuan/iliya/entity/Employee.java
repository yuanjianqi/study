package com.yuan.iliya.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 20:30
 * @since 1.8
 */
@Data
public class Employee implements Serializable {

    private Integer id;
    private String empName;
    private Double empSalary;
    private Integer empAge;
}
