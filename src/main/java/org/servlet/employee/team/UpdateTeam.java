package org.servlet.employee.team;

import org.dto.UserDTO;
import org.enums.EmployeeType;
import org.model.Team;
import org.repository.EmployeeRepository;
import org.repository.EmployeeRepositoryImpl;
import org.service.TeamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateTeam", value = "/UpdateTeam")
public class UpdateTeam extends HttpServlet {
    TeamService teamService = new TeamService();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("team", teamService.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/UpdateTeam.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String picture = request.getParameter("picture");
        Team team = new Team(id, name, type, picture, true);
        try {
            teamService.update(team);
            request.setAttribute("total_team", employeeRepository.countEmployeeByType(EmployeeType.TEAM));
            request.setAttribute("teams", teamService.getAllTeams());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Teams.jsp").forward(request, response);
    }
}