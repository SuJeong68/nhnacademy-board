package com.nhnacademy.servlet;

import com.nhnacademy.controller.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command = resolvedCommand(req.getServletPath(), req.getMethod());

            String view = command.execute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
                requestDispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("exception", e);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private Command resolvedCommand(String servletPath, String method) {
        Command command = null;

        if (servletPath.equals("/loginForm.do")) {
            command = new LoginFormController();
        } else if (servletPath.equals("/login.do")) {
            command = new LoginProcessingController();
        } else if (servletPath.equals("/logout.do")) {
            command = new LogoutController();
        } else if (servletPath.equals("/board.do")) {
            command = new BoardLoadController();
        } else if (servletPath.equals("/postForm.do")) {
            command = new PostFormController();
        } else if (servletPath.equals("/post.do")) {
            command = new PostProcessingController();
        } else if (servletPath.equals("/remove.do")) {
            command = new PostRemoveController();
        } else if (servletPath.equals("/modify.do")) {
            command = new PostModifyController();
        } else if (servletPath.equals("/userForm.do")) {
            command = new UserFormController();
        } else if (servletPath.equals("/userJoin.do")) {
            command = new UserJoinController();
        } else if (servletPath.equals("/userRemove.do")) {
            command = new UserRemoveController();
        } else if (servletPath.equals("/userModify.do")) {
            command = new UserModifyController();
        } else if (servletPath.equals("/changeLang.do")) {
            command = new ChangeLangUpdateController();
        }

        return command;
    }
}
