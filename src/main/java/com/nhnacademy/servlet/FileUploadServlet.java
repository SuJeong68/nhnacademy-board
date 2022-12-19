package com.nhnacademy.servlet;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Slf4j
@WebServlet(name = "fileUploadServlet", urlPatterns = "/upload")
@MultipartConfig(
        location = "/Users/sujeong/works/temp",
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 50,
        fileSizeThreshold = 1024
)
public class FileUploadServlet extends HttpServlet {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "/Users/sujeong/works/file-download";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadId = (String) req.getServletContext().getAttribute("uploadId");
        Users users = (Users) req.getServletContext().getAttribute("users");
        User user = users.getUser(uploadId);

        for (Part part: req.getParts()) {
            String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

            if (contentDisposition.contains("filename=")) {
                String fileName = extractFileName(contentDisposition);
                user.setProfileFileName(fileName);

                if (part.getSize() > 0) {
                    part.write(UPLOAD_DIR + File.separator + fileName);
                    part.delete();
                }

                users.modify(user);
                log.info(user.getId() + "/ " + user.getPassword() + "/ " + user.getName() + "/ " + user.getProfileFileName());
                req.getServletContext().setAttribute("users", users);

                resp.sendRedirect("/loginForm.jsp");
            } else {
                String formValue = req.getParameter(part.getName());
                log.error("{}={}", part.getName(), formValue);
            }
        }
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }
        return null;
    }
}
