package com.yuan.iliya.service.impl;

import com.yuan.iliya.dao.impl.EmployeeJdbcImpl;
import com.yuan.iliya.entity.Employee;
import com.yuan.iliya.service.EmployeeService;

import java.io.Serializable;
import java.util.List;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 21:15
 * @since 1.8
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeJdbcImpl employeeJdbc = new EmployeeJdbcImpl();
    /**
     * 保存一个员工信息
     *
     * @param employee 员工信息
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeJdbc.insert(employee);
    }

    /**
     * 更新一个员工信息
     *
     * @param employee 员工信息
     */
    @Override
    public void updateEmployee(Employee employee) {
        employeeJdbc.update(employee);
    }

    /**
     * 删除一个员工信息
     *
     * @param id
     */
    @Override
    public void deleteEmployeeById(Serializable id) {
        employeeJdbc.delete(id);
    }

    /**
     * 查找一个员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    @Override
    public Employee getEmployeeById(Serializable id) {
        return employeeJdbc.findById(id);
    }

    /**
     * 返回所有的员工信息
     *
     * @return 所有的员工信息
     */
    @Override
    public List<Employee> getEmployees() {
        return employeeJdbc.findAll();
    }
}
