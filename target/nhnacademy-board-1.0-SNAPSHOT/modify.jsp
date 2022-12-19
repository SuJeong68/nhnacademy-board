<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.nhnacademy.domain.Posts" %>
<%@ page import="com.nhnacademy.domain.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <% Posts posts = (Posts) request.getServletContext().getAttribute("posts");
    Post post = posts.getPost((Long) request.getServletContext().getAttribute("postId")); %>
    <form method="post" action="/modify.do">
        <fmt:message key="title" bundle="${message}"/> :<input type="text" name="title" value='<%=post.getTitle()%>'/><br/>
        <fmt:message key="content" bundle="${message}"/> :<input type="text" name="content" value='<%=post.getContent()%>'/><br/>
        <input type="submit" name="modify" value=<fmt:message key="modify" bundle="${message}"/>/>
    </form>
</body>
</html>
