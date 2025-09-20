package org.servlet.task;

import org.dto.UserDTO;
import org.enums.Priority;
import org.enums.Status;
import org.model.Task;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "UpdateTask", value = "/UpdateTask")
public class UpdateTask extends HttpServlet {
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
            request.setAttribute("task", taskRepository.getById(idTask));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/UpdateTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        Long idTask = Long.valueOf(request.getParameter("idTask"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        Date dateEnd = Date.valueOf(request.getParameter("date"));
        String description = request.getParameter("description");
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Status status = Status.valueOf(request.getParameter("status"));
        LocalDate date = LocalDate.now();
        Date dateStart = Date.valueOf(date);
        Task task = new Task(idTask, title, type, dateStart, dateEnd, description, priority, status);
        try {
            taskRepository.update(task);
            request.setAttribute("task", taskRepository.getTaskWithAssociated(idTask));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/ViewTask.jsp").forward(request, response);
    }
}