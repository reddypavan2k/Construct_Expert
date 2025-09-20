package org.servlet.user;

import org.enums.Role;
import org.model.User;
import org.repository.UserRepository;
import org.repository.UserRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            userRepository.delete(1L);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        String picture = request.getParameter("picture");
        Role role = Role.valueOf(request.getParameter("role"));
        User user = new User(1L, name, userName, userEmail, password, picture, role);
        try {
            userRepository.update(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
    }
}