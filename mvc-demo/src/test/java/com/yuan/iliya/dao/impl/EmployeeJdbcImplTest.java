package com.yuan.iliya.dao.impl;

import com.yuan.iliya.entity.Employee;

import java.util.List;

import static org.junit.Assert.*;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 21:01
 * @since 1.8
 */
public class EmployeeJdbcImplTest {
    EmployeeJdbcImpl employeeJdbc = new EmployeeJdbcImpl();

    @org.junit.Test
    public void insert() {
        Employee employee = new Employee();
        employee.setEmpName("jessy");
        employee.setEmpSalary(129381.00);
        employee.setEmpAge(20);
        employeeJdbc.insert(employee);
    }

    @org.junit.Test
    public void update() {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setEmpName("Linda");
        employee.setEmpSalary(1600.2);
        employee.setEmpAge(18);
        employeeJdbc.update(employee);

    }

    @org.junit.Test
    public void delete() {
        employeeJdbc.delete(4);
    }

    @org.junit.Test
    public void findById() {
        Employee employee = employeeJdbc.findById(3);
        System.out.println(employee);
    }

    @org.junit.Test
    public void findAll() {
        List<Employee> jdbcAll = employeeJdbc.findAll();
        System.out.println(jdbcAll);
    }
}