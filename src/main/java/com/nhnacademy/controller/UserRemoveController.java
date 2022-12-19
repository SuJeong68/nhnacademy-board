package com.nhnacademy.controller;

import com.nhnacademy.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserRepository users = (UserRepository) req.getServletContext().getAttribute("users");
        users.remove((String) req.getServletContext().getAttribute("userId"));
        req.getServletContext().setAttribute("users", users);
        return "/userInquiry.jsp";
    }
}
