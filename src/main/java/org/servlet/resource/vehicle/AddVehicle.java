package org.servlet.resource.vehicle;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.model.Vehicle;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.VehicleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "AddVehicle", value = "/AddVehicle")
public class AddVehicle extends HttpServlet {

    VehicleService vehicleService = new VehicleService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/CreateVehicle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String provider = request.getParameter("provider");
        Date acquisitionDate = Date.valueOf(request.getParameter("acquisitionDate"));
        String picture = request.getParameter("picture");
        String quantity = request.getParameter("quantity");

        Vehicle vehicle = new Vehicle(title, type, provider, acquisitionDate, picture, quantity, true);
        try {
            vehicleService.add(vehicle);
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
}