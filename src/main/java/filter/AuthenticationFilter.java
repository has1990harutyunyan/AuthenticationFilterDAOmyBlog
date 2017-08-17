package filter;


import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasmik on 10.07.2017.
 */
public class AuthenticationFilter implements Filter {
    List<String> includeURI = new ArrayList<String>();

    public void init(FilterConfig filterConfig) throws ServletException {
        includeURI.add("/admin");
        includeURI.add("/admin.jsp");
        includeURI.add("/addPost");
        includeURI.add("/addCategory");

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (includeURI.contains(request.getRequestURI())) {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.sendRedirect("login.jsp");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
