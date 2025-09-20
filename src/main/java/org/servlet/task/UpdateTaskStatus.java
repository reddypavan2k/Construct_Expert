package org.servlet.task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.enums.Status;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UpdateTaskStatus", value = "/UpdateTaskStatus")
public class UpdateTaskStatus extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> requestData = objectMapper.readValue(request.getInputStream(), new TypeReference<Map<String, Object>>() {});

        String idString = (String) requestData.get("id");
        Long id = Long.valueOf(idString);
        String status = (String) requestData.get("status");
        try {
            taskRepository.updateTaskStatus(id, Status.valueOf(status));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}