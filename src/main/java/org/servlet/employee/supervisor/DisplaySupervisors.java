package org.servlet.employee.supervisor;

import org.dto.UserDTO;
import org.enums.EmployeeType;
import org.repository.EmployeeRepository;
import org.repository.EmployeeRepositoryImpl;
import org.service.SupervisorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DisplaySupervisors", value = "/DisplaySupervisors")
public class DisplaySupervisors extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("total_supervisor", employeeRepository.countEmployeeByType(EmployeeType.SUPERVISOR));
            request.setAttribute("supervisors", supervisorService.getAllSupervisors());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Supervisors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}