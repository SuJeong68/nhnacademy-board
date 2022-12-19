package com.nhnacademy.controller;

import com.nhnacademy.domain.OneUser;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class UserJoinController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String password = req.getParameter("pwd");
        String name = req.getParameter("name");

        if (id.equals("") || password.equals("") || name.equals(""))
            return "/userForm.jsp";

        if (Objects.nonNull(id) && Objects.nonNull(password) && Objects.nonNull(name)) {
            Users users = (Users) req.getServletContext().getAttribute("users");

            if (Objects.isNull(users.getUser(id))) {
                User user = new OneUser(id, password, name, null);
                users.add(user);

                req.getServletContext().setAttribute("users", users);
                req.getServletContext().setAttribute("uploadId", id);
            } else {
                return "/userForm.jsp";
            }
        }
        return "redirect:/imageUpload.jsp";
    }
}
