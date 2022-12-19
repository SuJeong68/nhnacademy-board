package com.nhnacademy.controller;

import com.nhnacademy.domain.PostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PostRemoveController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        PostRepository posts = (PostRepository) req.getServletContext().getAttribute("posts");
        posts.remove((Long) req.getServletContext().getAttribute("postId"));
        return "/board.do";
    }
}
