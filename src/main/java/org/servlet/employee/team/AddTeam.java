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

@WebServlet(name = "AddTeam", value = "/AddTeam")
public class AddTeam extends HttpServlet {
    TeamService teamService = new TeamService();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/CreateTeam.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String picture = request.getParameter("picture");
        Team team = new Team(name, type, picture, true);
        try {
            teamService.add(team);
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