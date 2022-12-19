<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>LoginForm</title>

        <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
        <fmt:setBundle basename="message" var="message"/>
    </head>
<body>
    <form method="post" action="/login.do">
        <fmt:message key="id" bundle="${message}"/> : <input type="text" name="id"/><br/>
        <fmt:message key="password" bundle="${message}"/> : <input type="password" name="pwd"/><br/>
        <input type="submit" value='<fmt:message key="login" bundle="${message}"/>'/>
    </form>
    <form method="post" action="/userForm.jsp">
        <input type="submit" value='<fmt:message key="join" bundle="${message}"/>'/>
    </form>
</body>
</html>
