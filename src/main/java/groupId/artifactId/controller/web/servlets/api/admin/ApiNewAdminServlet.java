package groupId.artifactId.controller.web.servlets.api.admin;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.service.UserService;
import groupId.artifactId.service.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "NewAdmin", urlPatterns = "/api/admin/newAdmin")
public class ApiNewAdminServlet extends HttpServlet {
    private final IUserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        validateLogin(login);
        String password = req.getParameter("password");
        validatePassword(password);
        try {
            userService.saveAdmin(new UserDto(login, password, setName(), setDateOfBirth()));
        } catch (RuntimeException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/ui/singIn");
    }

    private void validateLogin(String login) {
        if (login == null || userService.getByLogin(login).isPresent()) {
            throw new IllegalArgumentException("Error 400. The login is not valid");
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Error 400. The password is not valid");
        }
    }

    private String setName() {
        return "Admin";
    }

    private LocalDate setDateOfBirth() {
        return LocalDate.EPOCH;
    }
}

