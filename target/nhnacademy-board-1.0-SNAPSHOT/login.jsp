<%@ page import="com.nhnacademy.domain.User" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <%User user = (User) request.getSession().getAttribute("user");%>
    <h3>Welcome, <%=user.getId()%></h3><br/>
    <a href="/board.jsp"><fmt:message key="board" bundle="${message}"/></a><br/>
    <a href="/logout.do"><fmt:message key="logout" bundle="${message}"/></a>
</body>
</html>
