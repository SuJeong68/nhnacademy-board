package com.nhnacademy.controller;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserModifyController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Users users = (Users) req.getServletContext().getAttribute("users");

        User user = users.getUser(String.valueOf(req.getServletContext().getAttribute("userId")));
        user.setPassword(req.getParameter("pwd"));
        user.setName(req.getParameter("name"));
        user.setProfileFileName(req.getParameter("profileName"));
        users.modify(user);

        req.getServletContext().setAttribute("users", users);

        return "/user.jsp?id=" + user.getId();
    }
}
