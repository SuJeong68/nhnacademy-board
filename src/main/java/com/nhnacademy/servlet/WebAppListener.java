package com.nhnacademy.servlet;

import com.nhnacademy.initializer.WebAppInitializer;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        try {
            WebAppInitializer initializer = new WebAppInitializer();
            initializer.onStartup(null, servletContext);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        long counter = 0;
        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFilePath))) {
            counter = dis.readLong();
        } catch (IOException | NullPointerException e) {
            log.error(String.valueOf(e));
        }

        servletContext.setAttribute("counter", counter);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get(servletContext.getResource(counterFilePath).toURI())))) {
            long counter = (long) servletContext.getAttribute("counter");

            dos.writeLong(counter);
            dos.flush();
        } catch (MalformedURLException e) {
            log.error(String.valueOf(e));
        } catch (IOException e) {
            log.error(String.valueOf(e));
        } catch (URISyntaxException e) {
            log.error(String.valueOf(e));
        }
    }
}
