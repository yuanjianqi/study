package com.yuan.iliya.dao.impl;

import com.yuan.iliya.dao.BaseDao;
import com.yuan.iliya.dao.JdbcUtil;
import com.yuan.iliya.entity.Employee;
import lombok.SneakyThrows;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 20:38
 * @since 1.8
 */
public class EmployeeJdbcImpl implements BaseDao<Employee> {
    /**
     * 向数据库插入一条记录
     *
     * @param employee 插入的实体对象
     */
    @SneakyThrows
    @Override
    public void insert(Employee employee) {
        Connection connection = JdbcUtil.getConnection();

        String sql = "insert into tb_emp(emp_name,emp_salary,emp_age) values (?, ? , ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,employee.getEmpName());
        statement.setObject(2,employee.getEmpSalary());
        statement.setObject(3,employee.getEmpAge());
        statement.execute();
        JdbcUtil.close(connection,statement);
    }

    /**
     * 向数据库更新一条记录
     *
     * @param employee 更新的实体对象
     */
    @SneakyThrows
    @Override
    public void update(Employee employee) {
        Connection connection = JdbcUtil.getConnection();

        String sql = "update tb_emp set emp_name = ? , emp_salary = ?, emp_age = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,employee.getEmpName());
        statement.setObject(2,employee.getEmpSalary());
        statement.setObject(3,employee.getEmpAge());
        statement.setObject(4,employee.getId());
        statement.execute();
        JdbcUtil.close(connection,statement);
    }

    /**
     * 根据id删除数据库一条记录
     *
     * @param id 数据id
     */
    @SneakyThrows
    @Override
    public void delete(Serializable id) {
        Connection connection = JdbcUtil.getConnection();
        String sql = "delete from tb_emp where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,id);
        statement.execute();
        JdbcUtil.close(connection,statement);
    }

    /**
     * 根据id查找数据库一条记录
     *
     * @param id 数据id
     * @return 对应的实体对象
     */
    @SneakyThrows
    @Override
    public Employee findById(Serializable id) {
        Employee employee = null;
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from tb_emp where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setEmpSalary(resultSet.getDouble(3));
            employee.setEmpAge(resultSet.getInt(4));
        }

        JdbcUtil.close(connection,statement);

        return employee;
    }

    /**
     * 查找实体对应的所有对象
     *
     * @return 对象List
     */
    @SneakyThrows
    @Override
    public List<Employee> findAll() {
        List<Employee> employees;
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from tb_emp";
        PreparedStatement statement = connection.prepareStatement(sql);


        ResultSet resultSet = statement.executeQuery();
        employees = new ArrayList<>();
        while (resultSet.next()){
            Employee employee;
            employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setEmpSalary(resultSet.getDouble(3));
            employee.setEmpAge(resultSet.getInt(4));
            employees.add(employee);
        }
        JdbcUtil.close(connection,statement);
        return employees;
    }
}
