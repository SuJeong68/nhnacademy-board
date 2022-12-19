package com.nhnacademy.initializer;

import com.nhnacademy.domain.OneUser;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.domain.Users;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@Slf4j
@HandlesTypes({
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        UserRepository userRepository = Users.getInstance();
        userRepository.add(new OneUser("admin", "12345", "관리자", null));
        ctx.setAttribute("users", userRepository);

        ctx.setAttribute("posts", new Posts());

        ctx.setInitParameter("lang", "ko");
        ctx.setInitParameter("counterFileName", "counter.dat");
    }
}