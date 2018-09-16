<%--
  Created by IntelliJ IDEA.
  User: Iliya Kaslana
  Date: 2018/9/15
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

    <%
        response.sendRedirect(request.getContextPath() + "/employee_list");
    %>
</body>
</html>
