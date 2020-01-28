<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="register_user_title" /></title>
</head>
<body>
    <h3><spring:message code="register_user_desc" /></h3>

    <form:form action="${pageContext.request.contextPath}/register_user_account/showResult" modelAttribute="userAccountData" method="post">

        <spring:message code="register_label_user_name" />&nbsp;
        <form:input path="userName"/>&nbsp;<br/>
        <font color=red><form:errors path="userName"/></font><br/><br/>

        <spring:message code="register_label_password" />&nbsp;
        <form:password path="password"/>&nbsp;<br/>
        <font color=red><form:errors path="password"/></font><br/><br/>

        <spring:message code="register_label_email" />&nbsp;
        <form:input path="email"/>&nbsp;<br/>
        <font color=red><form:errors path="email"/></font><br/><br/>

        <spring:message code="register_label_age" />&nbsp;
        <form:input path="age"/>&nbsp;<br/>
        <font color=red><form:errors path="age"/></font><br/><br/>

        <spring:message code="register_label_birthday" />&nbsp;
        <form:input path="birthday"/>&nbsp;<br/>
        <font color=red><form:errors path="birthday"/></font><br/><br/>

        <spring:message code="register_label_salary" />&nbsp;
        <form:input path="salary"/>&nbsp;<br/>
        <font color=red><form:errors path="salary"/></font><br/><br/>

        <input type="submit" value="Register"/>

    </form:form>

</body>
</html>