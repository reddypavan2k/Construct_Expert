package org.servlet.project;

import org.dto.UserDTO;
import org.repository.ProjectRepository;
import org.repository.ProjectRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewProject", value = "/ViewProject")
public class ViewProject extends HttpServlet {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("project",projectRepository.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/ViewProject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}