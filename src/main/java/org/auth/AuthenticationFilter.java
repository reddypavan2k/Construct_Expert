package org.auth;

import org.dto.UserDTO;
import org.enums.Role;
import org.repository.UserRepository;
import org.repository.UserRepositoryImpl;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/auth")
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRepository userRepository = new UserRepositoryImpl();
        UserDTO user = null;
        try {
            user = userRepository.authentication(username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (user != null) {
            if (user.getRole().equals(Role.ADMIN)) {
                session.setAttribute("user", user);
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect(((HttpServletRequest) request).getContextPath());
            }
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(((HttpServletRequest) request).getContextPath());
        }
    }
}