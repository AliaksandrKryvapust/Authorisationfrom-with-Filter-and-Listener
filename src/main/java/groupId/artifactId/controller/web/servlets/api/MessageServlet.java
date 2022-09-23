package groupId.artifactId.controller.web.servlets.api;

import groupId.artifactId.service.MessageService;
import groupId.artifactId.service.UserService;
import groupId.artifactId.util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "MessagePage", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final MessageService messageService = MessageService.getInstance();
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String destination = req.getParameter("destination");
        String message = req.getParameter("message");
        HttpSession session = req.getSession();
        try {
            userService.validateDestination(destination);
            messageService.validateInput(message);
            messageService.save(Helper.createMessageDto(LocalDateTime.now(),
                    (String) session.getAttribute("login"), destination, message));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/ui/user/chats");
    }
}
