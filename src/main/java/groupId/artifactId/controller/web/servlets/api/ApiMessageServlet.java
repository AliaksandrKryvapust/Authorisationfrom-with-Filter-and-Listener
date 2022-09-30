package groupId.artifactId.controller.web.servlets.api;

import groupId.artifactId.core.dto.MessageDto;
import groupId.artifactId.service.MessageService;
import groupId.artifactId.service.UserService;
import groupId.artifactId.service.api.IMessageService;
import groupId.artifactId.service.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "MessagePage", urlPatterns = "/api/message")
public class ApiMessageServlet extends HttpServlet {
    private final IMessageService messageService = MessageService.getInstance();
    private final IUserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String destination = req.getParameter("destination");
        String message = req.getParameter("message");
        HttpSession session = req.getSession();
        try {
            userService.validateDestination(destination);
            messageService.validateInput(message);
            messageService.save( new MessageDto(LocalDateTime.now(),
                    (String) session.getAttribute("login"), destination, message));
        } catch (Exception e) {
            resp.setStatus(500);
        }
        resp.setStatus(201);
        resp.sendRedirect(req.getContextPath() + "/ui/user/chats");
    }
}
