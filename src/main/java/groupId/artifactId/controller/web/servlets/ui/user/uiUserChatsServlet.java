package groupId.artifactId.controller.web.servlets.ui.user;

import groupId.artifactId.service.MessageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Chats", urlPatterns = "/ui/user/chats")
public class uiUserChatsServlet extends HttpServlet {
    private final MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        try {
            req.setAttribute("messageData",
                    messageService.getByDestination((String) session.getAttribute("login")));
        } catch (Exception e) {
            throw new ServletException("Error 500. Incorrect session attribute for login");
        }
        RequestDispatcher form = req.getRequestDispatcher("/chatForm.jsp");
        form.forward(req, resp);
    }
}
