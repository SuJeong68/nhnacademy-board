<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>UserForm</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <form method="post" action="/userJoin.do">
        <fmt:message key="id" bundle="${message}"/> : <input type="text" name="id"/><br/>
        <fmt:message key="password" bundle="${message}"/> : <input type="password" name="pwd"/><br/>
        <fmt:message key="name" bundle="${message}"/> : <input type="text" name="name"/><br/>
        <input type="submit" value='<fmt:message key="join" bundle="${message}"/>'/>
    </form>
</body>
</html>
