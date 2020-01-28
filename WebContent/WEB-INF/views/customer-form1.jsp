<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
        <title>Customer Registration Form</title>

        <style>
            .error {
                color: red
            }
        </style>
    </head>

    <body>
        <h1> Spring MVC 5 - Form Validation Example</h1>
        <i>Fill out the form. Asterisk (*) means required.</i>
        <br><br>
	<form action="${pageContext.request.contextPath}/shop/processForm" method="post">
	
	<input type="text" name="firstName">
	<form:errors path="customer.firstName" cssClass="error" />
	
	 <input type="submit" value="Submit" />
	 
	 
	</form>

       <%--  <form:form action="${pageContext.request.contextPath}/shop/processForm" modelAttribute="customer">

            First name:
            <form:input path="firstName" />
             <form:errors path="firstName" cssClass="error" />

            <br><br> Last name (*):
            <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error" />

            <br><br> Free passes (*):
            <form:input path="freePasses" />
            <form:errors path="freePasses" cssClass="error" />

            <br><br> Email (*):
            <form:input path="email" />
            <form:errors path="email" cssClass="error" />

            <br><br> Postal Code:
            <form:input path="postalCode" />
            <form:errors path="postalCode" cssClass="error" />

            <br><br>

            <input type="submit" value="Submit" />

        </form:form> --%>

    </body>
</html>