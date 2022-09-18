package groupId.artifactId.controller;

import groupId.artifactId.service.StatisticService;
import groupId.artifactId.service.VoteResultService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "VotingForm", urlPatterns = "/entry_form")
public class VoteServlet extends HttpServlet {
    private final StatisticService statisticService = StatisticService.getInstance();
    private final VoteResultService voteResultService = VoteResultService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dataForSingers", statisticService.getSingersForHtml());
        req.setAttribute("dataForGenres", statisticService.getGenresForHtml());
        RequestDispatcher form = req.getRequestDispatcher("/voteForm.jsp");
        form.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String singer = req.getParameter("singer");
        String[] genresArr = req.getParameterValues("genres");
        String message = req.getParameter("message");
        try{
            voteResultService.validate(singer,genresArr,message);
        } catch (Exception e){
            throw new ServletException(e);
        }
            statisticService.saveStatic(singer, genresArr, message);
        resp.sendRedirect(req.getContextPath() + "/statistic");
    }
}
