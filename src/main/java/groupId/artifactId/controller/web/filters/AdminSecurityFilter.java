package groupId.artifactId.controller.web.filters;

import groupId.artifactId.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        UserService userService = UserService.getInstance();
        if (session != null && session.getAttribute("login") != null) {
            if (userService.validateAdmin((String) session.getAttribute("login"))) {
                chain.doFilter(request, response);
            } else throw new ServletException("User is not admin! Access denied");
        } else
            res.sendRedirect(req.getContextPath() + "/ui/singIn");
    }

    @Override
    public void destroy() {

    }
}
