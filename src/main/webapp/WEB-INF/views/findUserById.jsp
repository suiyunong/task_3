<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理界面</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/user/findById" method="post">
        <input type="hidden" name="_method" value="GET">
        ID：<input type="text" name="id"><br>
        <input type="submit" value="查询">
    </form>
</div>
</body>
</html>
