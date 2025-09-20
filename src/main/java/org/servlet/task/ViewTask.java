package org.servlet.task;

import org.dto.UserDTO;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewTask", value = "/ViewTask")
public class ViewTask extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Long idTask = Long.valueOf(request.getParameter("idTask"));
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        try {
            request.setAttribute("task", taskRepository.getTaskWithAssociated(idTask));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/ViewTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}