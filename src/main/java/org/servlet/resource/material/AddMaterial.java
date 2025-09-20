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

@WebServlet(name = "AddMaterial", value = "/AddMaterial")
public class AddMaterial extends HttpServlet {
    MaterialService materialService = new MaterialService();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/CreateMaterial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String provider = request.getParameter("provider");
        Date acquisitionDate = Date.valueOf(request.getParameter("acquisitionDate"));
        String picture = request.getParameter("picture");
        String quantity = request.getParameter("quantity");

        Material material = new Material(title, type, provider, acquisitionDate, picture, quantity, true);
        try {
            materialService.add(material);
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