package com.nhnacademy.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.*;
import java.util.Objects;

@Slf4j
public class LoginFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            return "/loginForm.jsp";
        } else {
            return "";
        }
    }
}
