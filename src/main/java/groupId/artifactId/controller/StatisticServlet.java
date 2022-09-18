package groupId.artifactId.controller;

import groupId.artifactId.service.StatisticService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static groupId.artifactId.util.StatisticPrintUtil.sortedPrint;
import static groupId.artifactId.util.StatisticPrintUtil.sortedPrintWithScores;

@WebServlet(name = "Statistic", urlPatterns = "/statistic")
public class StatisticServlet extends HttpServlet {

    private final StatisticService statisticService =  StatisticService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p>" + sortedPrint(statisticService.getSortedVotes()) + "</p>");
        writer.println();
        writer.write("<p>" + sortedPrintWithScores(statisticService.getSortedVotesWithStatistic()) + "</p>");
    }
}
