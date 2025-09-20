//package org.auth;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*")
//public class ApplicationFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpSession session = httpRequest.getSession(false);
//
//        if (session == null || session.getAttribute("user") == null) {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth");
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//}
