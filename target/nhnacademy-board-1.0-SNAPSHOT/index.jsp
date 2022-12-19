<%@ page import="java.util.Objects" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>Home</title>

    <fmt:setLocale value="${pageContext.getServletContext().getAttribute('lang')}"/>
    <fmt:setBundle basename="message" var="message"/>
  </head>
  <body>
    <%User user = (User) request.getSession().getAttribute("user");
      long counter = (long) request.getServletContext().getAttribute("counter"); %>
    <h2><fmt:message key="welcome" bundle="${message}"/>, <%=user.getId()%></h2><br/>
    <p><fmt:message key="counter" bundle="${message}"/> : <%=counter%></p><br/>

    <a href="/board.jsp"><fmt:message key="board" bundle="${message}"/></a><br/>
    <a href="/profile.jsp?id=<%=user.getId()%>"><fmt:message key="profile" bundle="${message}"/></a><br/>

    <% if (user.getId().equals("admin")) { %>
      <a href="/userInquiry.jsp"><fmt:message key="inquiry" bundle="${message}"/></a><br/>
    <% } %>

    <a href="changeLang.jsp"><fmt:message key="language" bundle="${message}"/></a><br/>

    <a href="/logout.do"><fmt:message key="logout" bundle="${message}"/></a><br/>
  </body>
</html>
