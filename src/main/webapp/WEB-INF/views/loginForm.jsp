<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%--CSS and JS--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
    <script type="application/javascript" src="<c:url value="/resources/js/firstPage.js"/> "></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Login page</title>
</head>


<body>



<form method="post" action="<c:url value='j_spring_security_check'/>">
    <div class="wrap">
        <div class="avatar">
            <img src="http://www.mbari.org/earth/images/atom.png">
        </div>

            <input type="text" name="j_username" id="j_username" placeholder="username"/></td>
        <div class="bar">
            <i></i>
        </div>
            <input type="password" name="j_password" id="j_password" placeholer="password"/></td>

           <button type="submit" value="Sign in" onclick="firstPage.init();">Sign in</button>
        <div class="bar">
            <i></i>
        </div>
        <button type="submit" value="Sign in">Register? </button>

        <p>
            <c:if test="${error == true}">
                <b class="error">Invalid username or password.</b>
            </c:if>

            <c:if test="${msg ne null}">
                <b class="logout-success">${msg}</b>
            </c:if>

            <c:if test="${notAllowed ne null}">
                <b class="not-allowed">${notAllowed}</b>
            </c:if>
        </p>

    </div>

</form>

<p>
    <a href="${pageContext.request.contextPath}/index.html">Home page</a><br/>
</p>
</body>
</html>