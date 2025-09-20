package org.servlet.resource.equipment;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.EquipmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteEquipment", value = "/DeleteEquipment")
public class DeleteEquipment extends HttpServlet {
    EquipmentService equipmentService = new EquipmentService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            equipmentService.delete(id);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}