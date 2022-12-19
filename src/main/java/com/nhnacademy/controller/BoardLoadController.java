package com.nhnacademy.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.*;

@Slf4j
public class BoardLoadController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/board.jsp";
    }
}
