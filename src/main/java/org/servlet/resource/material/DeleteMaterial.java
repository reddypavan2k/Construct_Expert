package org.servlet.resource.material;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.MaterialService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteMaterial", value = "/DeleteMaterial")
public class DeleteMaterial extends HttpServlet {
    MaterialService materialService = new MaterialService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            materialService.delete(id);
            request.setAttribute("total_material", resourceRepository.countResourceByType(ResourceType.MATERIAL));
            request.setAttribute("materials", materialService.getAllMaterials());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Materials.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}