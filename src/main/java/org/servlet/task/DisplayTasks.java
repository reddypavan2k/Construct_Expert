package org.servlet.task;

import org.dto.TaskDTO;
import org.dto.UserDTO;
import org.enums.Status;
import org.model.Task;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "DisplayTasks", value = "/DisplayTasks")
public class DisplayTasks extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        try {
            List<TaskDTO> taskList = taskRepository.getAllTaskWithAssociated(id);
            request.setAttribute("taskToDo", taskList.stream().filter(task -> task.getStatus().equals(Status.TODO)).collect(Collectors.toList()));
            request.setAttribute("taskInProgress", taskList.stream().filter(task -> task.getStatus().equals(Status.IN_PROGRESS)).collect(Collectors.toList()));
            request.setAttribute("taskCompleted", taskList.stream().filter(task -> task.getStatus().equals(Status.COMPLETED)).collect(Collectors.toList()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}