<%@ page import="com.nhnacademy.domain.Users" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Modify</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <% Users users = (Users) request.getServletContext().getAttribute("users");
    User user = users.getUser((String) request.getServletContext().getAttribute("userId")); %>
    <form method="post" action="/userModify.do">
        <fmt:message key="id" bundle="${message}"/> : <%=user.getId()%><br/>
        <fmt:message key="password" bundle="${message}"/> : <input type="password" name="pwd" value='<%=user.getPassword()%>'/><br/>
        <fmt:message key="name" bundle="${message}"/> : <input type="text" name="name" value='<%=user.getName()%>'/><br/>
        <fmt:message key="profile" bundle="${message}"/> : <input type="text" name="profileName" value='<%=user.getProfileFileName()%>'/><br/>
        <input type="submit" value='<fmt:message key="modify" bundle="${message}"/>'/>
    </form>
</body>
</html>
