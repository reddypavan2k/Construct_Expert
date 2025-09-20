package org.servlet.resource.material;

import org.dto.UserDTO;
import org.enums.ResourceType;
import org.model.Material;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;
import org.service.MaterialService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateMaterial", value = "/UpdateMaterial")
public class UpdateMaterial extends HttpServlet {
    MaterialService materialService = new MaterialService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            request.setAttribute("material", materialService.getById(id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/UpdateMaterial.jsp").forward(request, response);
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

        Material material = new Material(id, title, type, provider, acquisitionDate, picture, quantity, true);
        try {
            materialService.update(material);
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
}