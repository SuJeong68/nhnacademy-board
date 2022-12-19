<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>postForm</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <form method="post" action="post.do">
        <fmt:message key="title" bundle="${message}"/> : <input type="text" name="title"/><br/>
        <fmt:message key="content" bundle="${message}"/> : <input type="text" name="content"/><br/>
        <input type="submit" value=<fmt:message key="register" bundle="${message}"/>></input>
    </form>
</body>
</html>
