<%--
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
    <title>Document</title>

    <style>
        #wrap{
            width: 400px;
            margin: 0 auto;
        }
    </style>
</head>
<body>

    <div id="wrap">
        <form action="<%=request.getContextPath()%>/employee_add">
            用户名: <input type="text" name="name"> <br>
            薪水: <input type="text" name="salary"> <br>
            年龄: <input type="text" name="age"> <br>
            <input type="submit" value="提交">
        </form>
    </div>

</body>
</html>
