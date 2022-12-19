package com.nhnacademy.controller;

import com.nhnacademy.domain.ConcretePost;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PostModifyController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Posts posts = (Posts) req.getServletContext().getAttribute("posts");

        Post post = posts.getPost((Long) req.getServletContext().getAttribute("postId"));
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));

        posts.modify(post);

        return "/post.jsp?id=" + post.getId();
    }
}
