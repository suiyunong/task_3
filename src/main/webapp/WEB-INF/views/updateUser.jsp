<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>修改用户信息</h1>
    <form  name="userForm">
        <input type="hidden" name="_method" value="PUT">
        <input value="${user.id}" name="id" type="hidden"/>
        姓名: <input type="text" name="name" value="${user.name}"><br>
        密码:<input type="text" name="password" value="${user.password}"><br>
        角色：<input type="text" name="userRole" value="${user.userRole}"><br>
        修改者：<input type="text" name="editorId" value="${user.editorId}"><br>
        特权：<input type="text" name="privileges" value="${user.privileges}"><br>
        <input type="submit" value="确认修改" onclick="updateUser()"> </input>
    </form>
</body>
</html>
<script>
    <%--alert(${user.id});--%>
    function updateUser(){
        var form = document.forms[0];
        form.action = "<%=basePath%>user/updateUser";
        form.method = "post";
        form.submit();
    }
</script>
