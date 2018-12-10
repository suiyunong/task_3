<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<html>
<head>
    <title>jsonTest</title>
</head>
<body>
<json:object >
    <json:property name="ID"        value="${user.id}"/>
    <json:property name="姓名"       value="${user.name}"/>
    <json:property name="QQ"        value="${user.qq} "/>
    <json:property name="修真类型"   value="${user.type}"/>
    <json:property name="入学时间"   value="${user.entro_time}"/>
    <json:property name="毕业学校"   value="${user.school}"/>
    <json:property name="线上学号"   value="${user.number}"/>
    <json:property name="日报链接"   value="${user.diary_link}"/>
    <json:property name="口号"       value="${user.slogan}"/>
    <json:property name="师兄"   value="${user.brother}"/>
</json:object>
</body>
</html>
