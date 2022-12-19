<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.nhnacademy.domain.Users" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inquiry</title>

    <style>
        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        td, th {
            border: 1px grey solid;
            text-align: left;
            padding: 5px 10px;
        }

        th {
            background: rgba(0,0,0,0.1);
        }
    </style>
    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Password</th>
            <th>Name</th>
            <th>ProfileFile</th>
        </tr>

    <% Users users = (Users) request.getServletContext().getAttribute("users");
    for (User user: users.getUsers()) { %>
        <tr onclick="location.href='/user.jsp?id=<%=user.getId()%>'">
            <td><%=user.getId()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getProfileFileName()%></td>
        </tr>
    <% } %>

    <form method="get" action="/">
        <input type="submit" name="home" value='<fmt:message key="home" bundle="${message}"/>'/>
    </form>
</body>
</html>
