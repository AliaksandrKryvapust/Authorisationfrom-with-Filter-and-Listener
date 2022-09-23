package groupId.artifactId.controller.web.servlets.ui.admin;

import groupId.artifactId.service.StatisticService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Statistic", urlPatterns = "/ui/admin/statistic")
public class UiAdminStatisticServlet extends HttpServlet {

    private final StatisticService statisticService = StatisticService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("statistic", statisticService.getData());
        RequestDispatcher form = req.getRequestDispatcher("/statisticForm.jsp");
        form.forward(req, resp);
    }
}
