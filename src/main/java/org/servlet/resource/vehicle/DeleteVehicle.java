package org.servlet.resource.vehicle;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.VehicleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteVehicle", value = "/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
    VehicleService vehicleService = new VehicleService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            vehicleService.delete(id);
            request.setAttribute("total_vehicle", resourceRepository.countResourceByType(ResourceType.VEHICLE));
            request.setAttribute("vehicles", vehicleService.getAllVehicles());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Vehicles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}