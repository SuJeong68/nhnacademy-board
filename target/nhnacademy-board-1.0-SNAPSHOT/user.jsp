<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.nhnacademy.domain.Users" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <%  Users users = (Users) request.getServletContext().getAttribute("users");
        User user = users.getUser(request.getParameter("id"));
        request.getServletContext().setAttribute("userId", user.getId());
    %>
    <ul>
        <li>User Id: <%=user.getId() %></li>
        <li>User Password: <%=user.getPassword() %></li>
        <li>User Name: <%=user.getName() %></li>
        <li>User ProfileFile: <%=user.getProfileFileName() %></li>
    </ul>

    <form method="get" action="/userInquiry.jsp">
        <input type="submit" name="inquiry" value='<fmt:message key="inquiry" bundle="${message}"/>'/>
    </form>
    <% if (!user.getId().equals("admin")) { %>
        <form method="get" action="/userModify.jsp">
            <input type="submit" name="modify" value='<fmt:message key="modify" bundle="${message}"/>'/>
        </form>
        <form method="post" action="/userRemove.do">
            <input type="submit" name="remove" value='<fmt:message key="remove" bundle="${message}"/>'/>
        </form>
    <% } %>
</body>
</html>
