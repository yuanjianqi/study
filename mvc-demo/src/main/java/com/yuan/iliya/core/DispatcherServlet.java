package com.yuan.iliya.core;

import com.yuan.iliya.controller.EmployeeController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 * 处理所有的请求的基类
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/15 14:45
 * @since 1.8
 */


public class DispatcherServlet extends HttpServlet {
    private EmployeeController employeeController;
    @Override
    public void init() throws ServletException {
        employeeController = new EmployeeController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith(".ico")){
            return;
        }

        System.out.println(requestURI);

        if (requestURI.contains("employee")){
            if (requestURI.endsWith("list")){
                employeeController.findEmployees(request,response);
                request.getRequestDispatcher("/WEB-INF/list_emp.jsp").forward(request,response);
            }

            if (requestURI.endsWith("delete")){
                employeeController.deleteEmployee(request,response);
                response.sendRedirect(request.getContextPath() + "/employee_list");
            }

            if (requestURI.endsWith("edit")){
                employeeController.findEmployeeById(request,response);
                request.getRequestDispatcher("/WEB-INF/edit_emp.jsp").forward(request,response);
            }

            if (requestURI.endsWith("update")){
                employeeController.updateEmployee(request,response);
                response.sendRedirect(request.getContextPath() + "/employee_list");

            }

            if (requestURI.endsWith("addUI")){
                request.getRequestDispatcher("/WEB-INF/add_emp.jsp").forward(request,response);
            }

            if (requestURI.endsWith("add")){
                employeeController.addEmployee(request,response);
                response.sendRedirect(request.getContextPath() + "/employee_list");

            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
