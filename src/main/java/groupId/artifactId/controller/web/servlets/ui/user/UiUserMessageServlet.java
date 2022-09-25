package groupId.artifactId.controller.web.servlets.ui.user;

import groupId.artifactId.service.UserService;
import groupId.artifactId.service.api.IUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Message", urlPatterns = "/ui/user/message")
public class UiUserMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        IUserService userService = UserService.getInstance();
        HttpSession session = req.getSession();
        session.setAttribute("button", userService.validateAdmin((String) session.getAttribute("login")));
        RequestDispatcher form = req.getRequestDispatcher("/messageForm.jsp");
        form.forward(req, resp);
    }
}
