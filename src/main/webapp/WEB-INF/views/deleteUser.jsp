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
    <h1>删除用户信息</h1>
</body>
</html>
<script>
    alert(${user.id});
    function deleteUser(){
        var form = document.forms[0];
        form.action = "<%=basePath%>user/delUser";
        form.method = "post";
        form.submit();
    }
</script>
