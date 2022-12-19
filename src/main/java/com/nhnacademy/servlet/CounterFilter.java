package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "counterFilter", urlPatterns = {"/post.jsp", "/profile.jsp", "/post.do"})
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = req.getServletContext();
        long counter = (long) servletContext.getAttribute("counter");
        servletContext.setAttribute("counter", ++counter);

        chain.doFilter(req, resp);
    }
}
