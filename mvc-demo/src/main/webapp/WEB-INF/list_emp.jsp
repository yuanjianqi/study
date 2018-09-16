<%@ page import="java.util.List" %>
<%@ page import="com.yuan.iliya.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Iliya Kaslana
  Date: 2018/9/16
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>暂无</title>

    <style>
        #wrap{
            width: 400px;
            margin: 0 auto;
        }
    </style>

</head>
<body>

    <div id="wrap">
        <h3>员工信息</h3>
        <table>
            <tr>
                <td>员工id</td>
                <td>员工名字</td>
                <td>员工薪水</td>
                <td>员工年龄</td>
                <td></td>
                <td></td>
            </tr>

            <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                if (employees != null && employees.size() > 0){
                    for (Employee employee :employees ){
             %>

            <tr>
                <td><%=employee.getId()%>
                </td>
                <td><%=employee.getEmpName()%>
                </td>
                <td><%=employee.getEmpSalary()%>
                </td>
                <td><%=employee.getEmpAge()%>
                </td>
                <td><a href="<%=request.getContextPath()%>/employee_delete?id=<%=employee.getId()%>">删除</a></td>
                <td><a href="<%=request.getContextPath()%>/employee_edit?id=<%=employee.getId()%>">修改</a></td>
            </tr>

            <%
                    }
                }
            %>
        </table>

        <a href="<%=request.getContextPath()%>/employee_addUI">添加用户</a>
    </div>
</body>
</html>
