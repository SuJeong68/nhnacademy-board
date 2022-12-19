package com.nhnacademy.controller;

import com.nhnacademy.domain.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PostProcessingController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        PostRepository posts = (PostRepository) req.getServletContext().getAttribute("posts");

        if (!title.equals("") && !content.equals("")) {
            Post post = new ConcretePost();
            post.setTitle(title);
            post.setContent(content);
            post.setWriterUserId(User.class.cast(req.getSession(false).getAttribute("user")).getId());

            posts.register(post);
            req.getServletContext().setAttribute("posts", posts);

            return "/post.jsp?id=" + post.getId();
        } else {
            return "/postForm.do";
        }
    }
}
