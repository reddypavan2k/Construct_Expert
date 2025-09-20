<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27/05/2024
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructXpert</title>
    <link rel="shortcut icon" href="assets/logo-head.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <style><%@include file="css/dashboard.css"%></style>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Barlow:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&amp;display=swap">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>
<body>
<nav class="sidebar">
    <div class="menu-bar">
        <div class="menu d-flex flex-column justify-content-between">
            <div class="first-option">
                <div class="menu-links">
                    <a class="nav-link my-2" href="dashboard">
                        <i class='bx bxs-dashboard'></i>
                        <span class="text nav-text">Dashboard</span>
                    </a>
                    <a class="nav-link my-2 active  hovered" href="projects">
                        <i class='bx bxs-building-house'></i>
                        <span class="text nav-text">Project</span>
                    </a>
                    <a class="nav-link my-2" href="teams">
                        <i class="fa-solid fa-users active-i"></i>
                        <span class="text nav-text active-span">Team</span>
                    </a>
                    <a class="nav-link my-2" href="supervisors">
                        <i class="fa-solid fa-user-tie"></i>
                        <span class="text nav-text">Supervisor</span>
                    </a>
                    <a class="nav-link my-2" href="vehicles">
                        <i class="fa-solid fa-truck-front"></i>
                        <span class="text nav-text">Vehicle</span>
                    </a>
                    <a class="nav-link my-2" href="equipments">
                        <i class="fa-solid fa-screwdriver-wrench"></i>
                        <span class="text nav-text">Equipment</span>
                    </a>
                    <a class="nav-link my-2" href="materials">
                        <i class="fa-solid fa-recycle"></i>
                        <span class="text nav-text">Material</span>
                    </a>
                </div>
            </div>
            <div class="last-option">
                <a class="nav-link my-2">
                    <i class="fa-solid fa-circle-info"></i>
                    <span class="text nav-text">Support & help</span>
                </a>
                <a class="nav-link my-2">
                    <i class="fa-solid fa-gear"></i>
                    <span class="text nav-text">Setting</span>
                </a>
                <a class="nav-link my-2">
                    <i class="fa-solid fa-right-from-bracket"></i>
                    <span class="text nav-text">Log out</span>
                </a>
            </div>
        </div>
    </div>
</nav>
<header class="header">
    <div class="topbar">
        <div class="toggle">
            <i class="fa-solid fa-bars"></i>
        </div>
        <div class="logo">
            <img src="assets/logo-white.png" alt="">
        </div>
        <div class="search">
            <label>
                <input type="text" placeholder="Search here">
                <i class="fa-solid fa-magnifying-glass"></i>
            </label>
        </div>
        <div class="icon">
            <i class="fa-regular fa-bell"></i>
            <i class="fa-regular fa-comment"></i>
        </div>
        <div class="info-user d-flex flex-column">
            <span>${user.getName()}</span>
            <span>${user.getRole()}</span>
        </div>
        <div class="user">
            <img src="${user.getPicture()}">
        </div>
</header>
<section class="main">
    <div class="main-header d-flex flex-row justify-content-between">
        <div class="main-section d-flex flex-row justify-content-between" style="width: 100%;">
            <h6>Projects <span>&#x2794; View Task</span> <span>&#x2794; ${projectName}</span></h6>
        </div>
    </div>
    <div class="task-details">
        <h6>${task.getTitle()}</h6>
        <div class="details">
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-signal"></i>
                    <span>Status </span>
                </div>
                <c:if test="${task.getStatus() eq 'COMPLETED'}">
                <p style="background-color: darkgreen" class="status"> Done</p>
                </c:if>
                <c:if test="${task.getStatus() eq 'IN_PROGRESS'}">
                    <p style="background-color: orange" class="status"> InProgress</p>
                </c:if>
                <c:if test="${task.getStatus() eq 'TODO'}">
                    <p style="background-color: darkred" class="status"> ToDo</p>
                </c:if>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-bolt"></i>
                    <span>Priority </span>
                </div>
                <c:if test="${task.getPriority() eq 'HIGH'}">
                <p style="background-color: red" class="status"> High</p>
                </c:if>
                <c:if test="${task.getPriority() eq 'MEDIUM'}">
                    <p style="background-color: green" class="status"> Medium</p>
                </c:if>
                <c:if test="${task.getPriority() eq 'LOW'}">
                    <p style="background-color: orange" class="status"> Low</p>
                </c:if>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-brands fa-square-font-awesome-stroke"></i>
                    <span>Type </span>
                </div>
                <p> ${task.getType()}</p>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-calendar-check"></i>
                    <span>Due date </span>
                </div>
                <p> ${task.getEndDate()}</p>
            </div>
            <div class="desc d-flex flex-column justify-content-between">
                <div>
                    <i class="fa-solid fa-font"></i>
                    <span>Description </span>
                </div>
                <span>${task.getDescription()}</span>
            </div>
        </div>
        <a class="update-task" href="update-task?id=${id}&name=${projectName}&idTask=${task.getId()}">Update</a>
    </div>
    <div class="employee-details">
        <h6>Employee</h6>
        <div class="employee">
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-user-tie"></i>
                    <span>Leader </span>
                </div>
                <div class="user d-flex flex-row justify-content-start align-items-center">
                    <img src="${task.getSupervisor().getPicture()}" alt="">
                    <p>${task.getSupervisor().getName()}</p>
                </div>

            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-people-group"></i>
                    <span>Team </span>
                </div>
                <div class="user d-flex flex-row justify-content-start align-items-center">
                    <img src="${task.getTeam().getPicture()}" alt="">
                    <p>${task.getTeam().getName()}</p>
                </div>
            </div>
            <a class="update-employee" href="update-task-employee?idTask=${task.getId()}&idSupervisor=${task.getSupervisor().getId()}&idTeam=${task.getTeam().getId()}">Update</a>
        </div>
    </div>
    <div class="resource-details">
        <h6>Resources</h6>
        <div class="overflow">
            <div class="scroll  d-flex flex-row">
                <c:forEach var="resource" items="${task.getResourceList()}">
                    <label for="material${resource.getId()}">
                        <img src="${resource.getPicture()}" alt="">
                    </label>
                </c:forEach>
                <a class="update-resource" href="update-task-resource?id=${task.getId()}">Update</a>
                <a class="add-resource" href="add-task-resource?id=${task.getId()}">Add</a>
            </div>
        </div>
    </div>
    <div class="task-actionn">
        <a class="save" href="tasks?id=${id}">Save</a>
        <a class="delete" href="delete-task?id${task.getId()}">Delete</a>
    </div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/chart.js"%></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.13/index.global.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/daygrid@6.1.13/index.global.min.js'></script>
<script><%@include file="js/calendar.js"%></script>

</body>
</html>

