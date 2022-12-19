<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.nhnacademy.domain.PostRepository" %>
<%@ page import="com.nhnacademy.domain.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board</title>
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
    <form method="post" action="/postForm.do">
        <input type="submit" name="register" value='<fmt:message key="register" bundle="${message}"/>'/>
    </form>
    <form method="get" action="/index.jsp">
        <input type="submit" name="home" value='<fmt:message key="home" bundle="${message}"/>'/>
    </form>

    <table>
        <tr>
            <th><fmt:message key="id" bundle="${message}"/></th>
            <th><fmt:message key="title" bundle="${message}"/></th>
            <th><fmt:message key="writerId" bundle="${message}"/></th>
            <th><fmt:message key="viewcount" bundle="${message}"/></th>
        </tr>
    <% PostRepository posts = (PostRepository) request.getServletContext().getAttribute("posts");
        for (Post post: posts.getPosts()) { %>
        <tr onclick="location.href='/post.jsp?id=<%=post.getId()%>'">
            <td style="background: rgba(0,0,0,0.06)"><%=post.getId()%></td>
            <td><%=post.getTitle()%></td>
            <td><%=post.getWriterUserId()%></td>
            <td><%=post.getViewCount()%></td>
        </tr>
    <%  } %>
    </table>
</body>
</html>
