package groupId.artifactId.controller.web.servlets.api;

import groupId.artifactId.core.dto.UserDto;
import groupId.artifactId.service.UserService;
import groupId.artifactId.service.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name = "Register", urlPatterns = "/api/user")
public class ApiRegisterServlet extends HttpServlet {
    private final IUserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        validateLogin(login);
        String password = req.getParameter("password");
        validatePassword(password);
        String name = req.getParameter("name");
        validateName(name);
        String dateOfBirth = req.getParameter("dateOfBirth");
        validateDateOfBirth(dateOfBirth);
        try {
            userService.save(new UserDto(login, password, name, LocalDate.parse(dateOfBirth)));
        } catch (RuntimeException e) {
            resp.setStatus(500);
        }
        resp.setStatus(201);
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

    private void validateName(String name) {
        if (name == null || !name.matches("[A-Za-z\\s]{4,20}")) {
            throw new IllegalArgumentException("Error 400. The name is not valid");
        }
    }

    private void validateDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || !dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Error 400. Birth date is not valid");
        }
    }
}
