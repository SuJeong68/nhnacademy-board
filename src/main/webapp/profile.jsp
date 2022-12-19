<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page import="com.nhnacademy.domain.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <%  String UPLOAD_DIR = "/Users/sujeong/works/file-download/";
        Users users = (Users) request.getServletContext().getAttribute("users");
        User user = users.getUser(request.getParameter("id"));%>
    <p><fmt:message key="id" bundle="${message}"/>: <%=user.getId()%></p>
    <p><fmt:message key="profileFile" bundle="${message}"/>: <%=user.getProfileFileName()%></p>
    <img src= "<%=UPLOAD_DIR + user.getProfileFileName()%>" style="width: 500px; height: 500px"/>
    <form method="get" action="/">
        <input type="submit" name="home" value='<fmt:message key="home" bundle="${message}"/>'/>
    </form>
</body>
</html>
