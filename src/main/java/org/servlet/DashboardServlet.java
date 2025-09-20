package org.servlet;

import org.dto.UserDTO;
import org.repository.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DashboardServlet", value = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        try {
            request.setAttribute("projects", projectRepository.projectProgress());
            request.setAttribute("total_project", projectRepository.allProjects());
            request.setAttribute("total_budget", (int) (projectRepository.countBudget()/1000));
            request.setAttribute("total_resource", resourceRepository.allResources());
            request.setAttribute("total_employee", employeeRepository.allEmployees());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}