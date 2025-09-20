package org.servlet.project;

import org.dto.UserDTO;
import org.enums.Status;
import org.model.Project;
import org.repository.ProjectRepository;
import org.repository.ProjectRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateProject", value = "/UpdateProject")
public class UpdateProject extends HttpServlet {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("project", projectRepository.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/UpdateProject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String geolocation = request.getParameter("geolocation");
        Date dateStart = Date.valueOf(request.getParameter("dateStart"));
        Date dateEnd = Date.valueOf(request.getParameter("dateEnd"));
        Status status = Status.valueOf(request.getParameter("status"));
        String description = request.getParameter("description");
        Integer room = Integer.parseInt(request.getParameter("room"));
        Integer bath = Integer.parseInt(request.getParameter("bath"));
        Integer garage = Integer.parseInt(request.getParameter("garage"));
        Integer terrace = Integer.parseInt(request.getParameter("terrace"));
        String wallMaterial = request.getParameter("wallMaterial");
        String foundationType = request.getParameter("foundationType");
        String roofingType = request.getParameter("roofingType");
        Double areaSize = Double.parseDouble(request.getParameter("areaSize"));
        Double budget = Double.parseDouble(request.getParameter("budget"));
        String planFloor = request.getParameter("planFloor");
        String picture = request.getParameter("picture");

        Project project = new Project(id, name, geolocation, dateStart, dateEnd, status, description, room, bath, garage, terrace,
                wallMaterial, foundationType, roofingType, areaSize, budget, planFloor, picture);
        try {
            projectRepository.update(project);
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
}