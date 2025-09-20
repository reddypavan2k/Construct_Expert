package org.servlet.employee.supervisor;

import org.dto.UserDTO;
import org.enums.EmployeeType;
import org.model.Supervisor;
import org.repository.EmployeeRepository;
import org.repository.EmployeeRepositoryImpl;
import org.service.SupervisorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateSupervisor", value = "/UpdateSupervisor")
public class UpdateSupervisor extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("total_supervisor", employeeRepository.countEmployeeByType(EmployeeType.SUPERVISOR));
            request.setAttribute("supervisor", supervisorService.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/UpdateSupervisor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String picture = request.getParameter("picture");
        Supervisor supervisor = new Supervisor(id, name, type, picture, true);
        try {
            supervisorService.update(supervisor);
            request.setAttribute("supervisors", supervisorService.getAllSupervisors());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Supervisors.jsp").forward(request, response);
    }
}