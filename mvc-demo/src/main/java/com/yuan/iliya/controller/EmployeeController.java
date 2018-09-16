package com.yuan.iliya.controller;

import com.yuan.iliya.entity.Employee;
import com.yuan.iliya.service.EmployeeService;
import com.yuan.iliya.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 21:20
 * @since 1.8
 */
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String empName = request.getParameter("name");
        Double empSalary = Double.valueOf(request.getParameter("salary"));
        Integer empAge = Integer.valueOf(request.getParameter("age"));

        Employee employee = new Employee();
        employee.setEmpName(empName);
        employee.setEmpSalary(empSalary);
        employee.setEmpName(empName);

        employeeService.saveEmployee(employee);
    }

    public void updateEmployee(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        Integer id = Integer.valueOf(request.getParameter("id"));
        String empName = request.getParameter("name");
        Double empSalary = Double.valueOf(request.getParameter("salary"));
        Integer empAge = Integer.valueOf(request.getParameter("age"));
        Employee employee = new Employee();
        employee.setId(id);
        employee.setEmpName(empName);
        employee.setEmpSalary(empSalary);
        employee.setEmpName(empName);

        employeeService.updateEmployee(employee);
    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        Integer id = Integer.valueOf(request.getParameter("id"));
        employeeService.deleteEmployeeById(id);
    }

    public void findEmployeeById(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        Integer id = Integer.valueOf(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        request.setAttribute("employee",employee);
    }

    public void findEmployees(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        List<Employee> employees = employeeService.getEmployees();
        request.setAttribute("employees",employees);
    }
}
