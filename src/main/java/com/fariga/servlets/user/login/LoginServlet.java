package com.fariga.servlets.user.login;

import com.fariga.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/user/login/")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    public void init(ServletConfig config) {
        log.info("LoginServlet: init method starts");
        userService = (UserService) config.getServletContext().getAttribute("paramUserService");
    }

    //does forward to JSP login
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/user/login/login.jsp").forward(req, resp);
    }

    //change User status to logged-in and redirect to success page
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!username.isEmpty() && !password.isEmpty()) {
            boolean checkingResult = userService.check(username, password);
            if (checkingResult) {
                boolean loginUpdateStatus = userService.updateLoginStatus(username);
                log.info("LoginServlet : User {} was {} ", username, loginUpdateStatus);
                req.getRequestDispatcher("/WEB-INF/user/login/success.jsp").forward(req, resp);
            } else {
                log.info("LoginServlet: doPost error");
                resp.sendError(404, "Such user '" + username + "' - is not found!!!");}
        }
    }
}
