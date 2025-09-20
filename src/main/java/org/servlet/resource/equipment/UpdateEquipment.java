package org.servlet.resource.equipment;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.model.Equipment;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.EquipmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateEquipment", value = "/UpdateEquipment")
public class UpdateEquipment extends HttpServlet {
    EquipmentService equipmentService = new EquipmentService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("equipment", equipmentService.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/UpdateEquipment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String provider = request.getParameter("provider");
        Date acquisitionDate = Date.valueOf(request.getParameter("acquisitionDate"));
        String picture = request.getParameter("picture");
        String quantity = request.getParameter("quantity");

        Equipment equipment = new Equipment(id, title, type, provider, acquisitionDate, picture, quantity, true);
        try {
            equipmentService.update(equipment);
            request.setAttribute("total_equipment", resourceRepository.countResourceByType(ResourceType.EQUIPMENT));
            request.setAttribute("equipments", equipmentService.getAllEquipment());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Equipments.jsp").forward(request, response);
    }
}