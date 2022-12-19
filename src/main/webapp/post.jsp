<%@ page import="com.nhnacademy.domain.Post" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.nhnacademy.domain.Posts" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
</head>
<body>
    <%  Posts posts = (Posts) request.getServletContext().getAttribute("posts");
        Post post = posts.getPost(Long.parseLong(request.getParameter("id")));
        LocalDateTime date = post.getWriteTime();
        post.increaseViewCount();
    %>
    <ul>
        <li>Post Id: <%=post.getId() %></li>
        <li>Viewcount: <%= post.getViewCount() %></li>
        <li onclick="location.href='/profile.jsp?id=<%=post.getWriterUserId()%>'">Writer Id: <%= post.getWriterUserId()%></li>
        <li>Date: <%= date.getYear() + "/" + date.getMonth() + "/" + date.getDayOfMonth()
                + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() %></li>
        <li>Title: <%= post.getTitle() %></li>
        <li>Content: <%= post.getContent() %></li>
    </ul>

    <form method="post" action="/board.do">
        <input type="submit" name="board" value='<fmt:message key="board" bundle="${message}"/>'/>
    </form>

    <% if (post.getWriterUserId().equals(User.class.cast(request.getSession(false).getAttribute("user")).getId())) { %>
    <% request.getServletContext().setAttribute("postId", post.getId());%>
        <form method="get" action="/modify.jsp">
            <input type="submit" name="modify" value='<fmt:message key="modify" bundle="${message}"/>'/>
        </form>
        <form method="post" action="/remove.do">
            <input type="submit" name="remove" value='<fmt:message key="remove" bundle="${message}"/>'/>
        </form>
    <% } %>
</body>
</html>
