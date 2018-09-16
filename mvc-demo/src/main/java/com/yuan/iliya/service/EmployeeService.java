package com.yuan.iliya.service;

import com.yuan.iliya.entity.Employee;

import java.io.Serializable;
import java.util.List;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 21:10
 * @since 1.8
 */
public interface EmployeeService {

    /**
     * 保存一个员工信息
     * @param employee 员工信息
     */
    void saveEmployee(Employee employee);

    /**
     * 更新一个员工信息
     * @param employee 员工信息
     */
    void updateEmployee(Employee employee);

    /**
     * 删除一个员工信息
     * @param id
     */
    void deleteEmployeeById(Serializable id);

    /**
     * 查找一个员工信息
     * @param id 员工id
     * @return 员工信息
     */
    Employee getEmployeeById(Serializable id);

    /**
     * 返回所有的员工信息
     * @return 所有的员工信息
     */
    List<Employee> getEmployees();
}
