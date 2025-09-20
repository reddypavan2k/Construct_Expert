<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24/05/2024
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
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
                    <a class="nav-link hovered my-2 active" href="projects">
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
<section class=" main">
    <div class="main-header d-flex flex-row justify-content-between">
        <div class="main-section d-flex flex-row justify-content-between" style="width: 100%;">
            <h6>Projects <span>&#x2794; Project Tasks</span> <span>&#x2794; ${projectName}</span></h6>
            <a class="add-task" href="add-task?id=${id}&name=${projectName}">Add Task</a>
        </div>
    </div>
    <div class="tasks d-flex flex-row justify-content-center">
        <div class="todo">
            <div class="task-title d-flex flex-row justify-content-between">
                <h6>Todo list </h6>
                <i class="fa-solid fa-ellipsis"></i>
            </div>
            <div class="task-action">
                <a href=""><i class="fa-solid fa-plus"></i></a>
            </div>
            <div class="task tbox">
                <div class="task-overflow  d-flex flex-column">
                    <c:forEach var="task" items="${taskToDo}">
                    <a href="view-task?id=${id}&name=${projectName}&idTask=${task.getId()}"class="task-view" draggable="true" data-id="${task.getId()}">
                            <div class="up d-flex flex-row justify-content-between">
                                <h6>${task.getTitle()}</h6>
                                <div class="days-left">
                                    <i class="fa-regular fa-clock"></i>
                                    <c:if test="${task.getDaysLeft() eq 0}">
                                        <span>Today</span>
                                    </c:if>
                                    <c:if test="${task.getDaysLeft() ne 0}">
                                        <span>${task.getDaysLeft()} days</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="middle">
                                <span>${task.getDescription()}</span>
                            </div>
                            <div class="down d-flex flex-row justify-content-between">
                                <div class="attachement-comment d-flex flex-row justify-content-around">
                                    <div class="attachement d-flex flex-row align-items-center">
                                        <i class="fa-solid fa-paperclip"></i>
                                        <span>5</span>
                                    </div>
                                    <div class="comment d-flex flex-row align-items-center">
                                        <i class="fa-regular fa-comment-dots"></i>
                                        <span>2</span>
                                    </div>
                                </div>
                                <div class="priority">
                                    <c:if test="${task.getPriority() eq 'HIGH'}">
                                    <div style="background-color: red" class="priority-bar"></div>
                                    </c:if>
                                    <c:if test="${task.getPriority() eq 'MEDIUM'}">
                                     <div style="background-color: green" class="priority-bar"></div>
                                     </c:if>
                                    <c:if test="${task.getPriority() eq 'LOW'}">
                                        <div style="background-color: yellow" class="priority-bar"></div>
                                      </c:if>
                                </div>
                                <div class="contributor">
                                    <img src="${task.getSupervisor().getPicture()}" alt="">
                                    <section class="plus">
                                        +
                                    </section>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="doing">
            <div class="task-title d-flex flex-row justify-content-between">
                <h6>InProgress list </h6>
                <i class="fa-solid fa-ellipsis"></i>
            </div>
            <div class="task-action">
                <a href=""><i class="fa-solid fa-plus"></i></a>
            </div>
            <div class="task tbox">
                <div class="task-overflow  d-flex flex-column">
                    <c:forEach var="task" items="${taskInProgress}">
                        <a href="view-task?id=${id}&name=${projectName}&idTask=${task.getId()}" class="task-view" draggable="true" data-id="${task.getId()}">
                                <div class="up d-flex flex-row justify-content-between">
                                    <h6>${task.getTitle()}</h6>
                                    <div class="days-left">
                                        <i class="fa-regular fa-clock"></i>
                                        <c:if test="${task.getDaysLeft() eq 0}">
                                            <span>Today</span>
                                        </c:if>
                                        <c:if test="${task.getDaysLeft() ne 0}">
                                            <span>${task.getDaysLeft()} days</span>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="middle">
                                    <span>${task.getDescription()}</span>
                                </div>
                                <div class="down d-flex flex-row justify-content-between">
                                    <div class="attachement-comment d-flex flex-row justify-content-around">
                                        <div class="attachement d-flex flex-row align-items-center">
                                            <i class="fa-solid fa-paperclip"></i>
                                            <span>5</span>
                                        </div>
                                        <div class="comment d-flex flex-row align-items-center">
                                            <i class="fa-regular fa-comment-dots"></i>
                                            <span>2</span>
                                        </div>
                                    </div>
                                    <div class="priority">
                                        <c:if test="${task.getPriority() eq 'HIGH'}">
                                            <div style="background-color: red" class="priority-bar"></div>
                                        </c:if>
                                        <c:if test="${task.getPriority() eq 'MEDIUM'}">
                                            <div style="background-color: green" class="priority-bar"></div>
                                        </c:if>
                                        <c:if test="${task.getPriority() eq 'LOW'}">
                                            <div style="background-color: yellow" class="priority-bar"></div>
                                        </c:if>
                                    </div>
                                    <div class="contributor">
                                        <img src="${task.getSupervisor().getPicture()}" alt="">
                                        <section class="plus">
                                            +
                                        </section>
                                    </div>
                                </div>
                            </a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="done">
            <div class="task-title d-flex flex-row justify-content-between">
                <h6>Completed list </h6>
                <i class="fa-solid fa-ellipsis"></i>
            </div>
            <div class="task-action">
                <a href=""><i class="fa-solid fa-plus"></i></a>
            </div>
            <div class="task tbox">
                <div class="task-overflow  d-flex flex-column">
                    <c:forEach var="task" items="${taskCompleted}">
                        <a href="view-task?id=${id}&name=${projectName}&idTask=${task.getId()}" class="task-view" draggable="true" data-id="${task.getId()}">
                                <div class="up d-flex flex-row justify-content-between">
                                    <h6>${task.getTitle()}</h6>
                                    <div class="days-left">
                                        <i class="fa-regular fa-clock"></i>
                                        <c:if test="${task.getDaysLeft() eq 0}">
                                        <span>Today</span>
                                        </c:if>
                                        <c:if test="${task.getDaysLeft() ne 0}">
                                            <span>${task.getDaysLeft()} days</span>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="middle">
                                    <span>${task.getDescription()}</span>
                                </div>
                                <div class="down d-flex flex-row justify-content-between">
                                    <div class="attachement-comment d-flex flex-row justify-content-around">
                                        <div class="attachement d-flex flex-row align-items-center">
                                            <i class="fa-solid fa-paperclip"></i>
                                            <span>5</span>
                                        </div>
                                        <div class="comment d-flex flex-row align-items-center">
                                            <i class="fa-regular fa-comment-dots"></i>
                                            <span>2</span>
                                        </div>
                                    </div>
                                    <div class="priority">
                                        <c:if test="${task.getPriority() eq 'HIGH'}">
                                            <div style="background-color: red" class="priority-bar"></div>
                                        </c:if>
                                        <c:if test="${task.getPriority() eq 'MEDIUM'}">
                                            <div style="background-color: green" class="priority-bar"></div>
                                        </c:if>
                                        <c:if test="${task.getPriority() eq 'LOW'}">
                                            <div style="background-color: yellow" class="priority-bar"></div>
                                        </c:if>
                                    </div>
                                    <div class="contributor">
                                        <img src="${task.getSupervisor().getPicture()}" alt="">
                                        <section class="plus">
                                            +
                                        </section>
                                    </div>
                                </div>
                            </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/script.js"%></script>


</body>

</html>
