package org.servlet.task;

import org.dto.ResourceDTO;
import org.dto.TaskDTO;
import org.dto.UserDTO;
import org.enums.EmployeeType;
import org.enums.Priority;
import org.enums.ResourceType;
import org.enums.Status;
import org.model.Employee;
import org.model.Resource;
import org.model.Task;
import org.repository.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AddTask", value = "/AddTask")
public class AddTask extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    TaskResourceRepository taskResourceRepository = new TaskResourceRepositoryImpl();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    TaskEmployeeRepository taskEmployeeRepository = new TaskEmployeeRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        LocalDate limitDate = LocalDate.now();
        request.setAttribute("limit", limitDate);
        try {
            List<Resource> resources = resourceRepository.getAllAvailable();
            request.setAttribute("vehicles", resources.stream().filter(resource -> resource.getResourceType().equals(ResourceType.VEHICLE)).collect(Collectors.toList()));
            request.setAttribute("equipments", resources.stream().filter(resource -> resource.getResourceType().equals(ResourceType.EQUIPMENT)).collect(Collectors.toList()));
            request.setAttribute("materials", resources.stream().filter(resource -> resource.getResourceType().equals(ResourceType.MATERIAL)).collect(Collectors.toList()));
            List<Employee> employees = employeeRepository.allAvailableEmployee();
            request.setAttribute("supervisors", employees.stream().filter(employee -> employee.getEmployeeType().equals(EmployeeType.SUPERVISOR)).collect(Collectors.toList()));
            request.setAttribute("teams", employees.stream().filter(employee -> employee.getEmployeeType().equals(EmployeeType.TEAM)).collect(Collectors.toList()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/CreateTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        Date dateEnd = Date.valueOf(request.getParameter("date"));
        String description = request.getParameter("description");
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Status status = Status.valueOf(request.getParameter("status"));
        LocalDate date = LocalDate.now();
        Date dateStart = Date.valueOf(date);
        Task task = new Task(title, type, dateStart, dateEnd, description, priority, status);
        String[] vehicles = request.getParameterValues("vehicle");
        String[] vehiclesQuantity = request.getParameterValues("quantityVehicle");
        String[] equipments = request.getParameterValues("equipment");
        String[] equipmentsQuantity = request.getParameterValues("quantityEquipment");
        String[] materials = request.getParameterValues("material");
        String[] materialsQuantity = request.getParameterValues("quantityMaterial");
        List<ResourceDTO> resourceDTOList = new ArrayList<>();
        for (int i = 0; i < vehicles.length; i++){
            ResourceDTO resourceDTO = new ResourceDTO(Long.valueOf(vehicles[i]), vehiclesQuantity[i]);
            resourceDTOList.add(resourceDTO);
        }
        for (int i = 0; i < equipments.length; i++){
            ResourceDTO resourceDTO = new ResourceDTO(Long.valueOf(equipments[i]), equipmentsQuantity[i]);
            resourceDTOList.add(resourceDTO);
        }
        for (int i = 0; i < materials.length; i++){
            ResourceDTO resourceDTO = new ResourceDTO(Long.valueOf(materials[i]), materialsQuantity[i]);
            resourceDTOList.add(resourceDTO);
        }
        Long supervisorId = Long.valueOf(request.getParameter("supervisor"));
        Long teamId = Long.valueOf(request.getParameter("team"));
        try {
            Long idTask = taskRepository.add(id, task);
            taskResourceRepository.AffectResourceToTask(idTask, resourceDTOList);
            taskResourceRepository.UpdateResourceQuantity(resourceDTOList);
            taskEmployeeRepository.AffectEmployeeToTask(idTask,supervisorId);
            taskEmployeeRepository.UpdateEmployeeAvailability(supervisorId);
            taskEmployeeRepository.AffectEmployeeToTask(idTask, teamId);
            taskEmployeeRepository.UpdateEmployeeAvailability(teamId);
            List<TaskDTO> taskList = taskRepository.getAllTaskWithAssociated(id);
            request.setAttribute("taskToDo", taskList.stream().filter(task1 -> task1.getStatus().equals(Status.TODO)).collect(Collectors.toList()));
            request.setAttribute("taskInProgress", taskList.stream().filter(task1 -> task1.getStatus().equals(Status.IN_PROGRESS)).collect(Collectors.toList()));
            request.setAttribute("taskCompleted", taskList.stream().filter(task1-> task1.getStatus().equals(Status.COMPLETED)).collect(Collectors.toList()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("id", id);
        request.setAttribute("projectName", name);
        this.getServletContext().getRequestDispatcher("/Tasks.jsp").forward(request, response);
    }
}