<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/22
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <style>
        .container{
            width: 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row" >
        <div class="col-md-12">
            <form class="form-horizontal">

                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">name</label>
                    <div class="col-sm-10">
                        <input type="text"  name="name" class="form-control" id="inputName" placeholder="name">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">password</label>
                    <div class="col-sm-10">
                        <input type="text"  name="password" class="form-control" id="inputPassword" placeholder="password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputUserRole" class="col-sm-2 control-label">userRole</label>
                    <div class="col-sm-10">
                        <input type="text"  name="userRole" class="form-control" id="inputUserRole" placeholder="userRole">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEditorId" class="col-sm-2 control-label">editorId</label>
                    <div class="col-sm-10">
                        <input type="text"  name="editorId" class="form-control" id="inputEditorId" placeholder="editorId">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPrivileges" class="col-sm-2 control-label">privileges</label>
                    <div class="col-sm-10">
                        <input type="text"  name="privileges" class="form-control" id="inputPrivileges" placeholder="privileges">
                    </div>
                </div>
                    <input type="hidden" name="_method" value="POST">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button onclick="addUser()" type="submit" class="btn btn-success">添加</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function addUser(){
        var form = document.forms[0];
        form.action = "<%=basePath%>user/addUser";
        form.method = "post";
        form.submit();
    }
</script>