package org.servlet.project;

import org.dto.UserDTO;
import org.repository.ProjectRepository;
import org.repository.ProjectRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProject", value = "/DeleteProject")
public class DeleteProject extends HttpServlet {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            projectRepository.delete(id);
            request.setAttribute("projects", projectRepository.projectProgress());
            request.setAttribute("total_project", projectRepository.allProjects());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Projects.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}