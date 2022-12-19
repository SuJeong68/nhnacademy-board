package com.nhnacademy.controller;

import com.nhnacademy.domain.OneUser;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.domain.Users;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.*;
import java.util.Objects;

@Slf4j
public class LoginProcessingController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String reqId = req.getParameter("id");
        String reqPassword = req.getParameter("pwd");


        Users users = (Users) req.getServletContext().getAttribute("users");
        if (Objects.nonNull(users.getUser(reqId)) && Objects.equals(users.getUser(reqId).getPassword(), reqPassword)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", users.getUser(reqId));

            return "/";
        } else {
            return "redirect:/loginForm.jsp";
        }
    }
}
