package groupId.artifactId.controller.web.servlets.api;

import groupId.artifactId.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            userService.validateUser(login, password);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", login);
        resp.sendRedirect(req.getContextPath() + "/ui/user/message");
    }
}
