<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27/05/2024
  Time: 16:42
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
            <h6>Projects <span>&#x2794; Create Task</span> <span>&#x2794; ${projectName}</span></h6>
        </div>
    </div>
    <div class="create-task">
        <form action="update-task" method="post">
            <div class="form-task">
                <div class="task-head d-flex flex-row justify-content-between">
                    <div class="task-title">
                        <label for="title">Task title :</label>
                        <i class="fa-solid fa-thumbtack"></i>
                        <input type="text" id="title" class="title" name="title" placeholder="Enter task title "
                               required value="${task.getTitle()}">
                    </div>
                    <div class="task-type">
                        <label for="type">Task type :</label>
                        <i class="fa-solid fa-font-awesome"></i>
                        <input type="text" id="type" class="type" name="type" placeholder="Enter task type "
                               required value="${task.getType()}">
                    </div>
                    <div class="due-date">
                        <label for="date">Task due date :</label>
                        <input type="date" id="date" class="date" name="date" required value="${task.getEndDate()}">
                    </div>
                </div>
                <div class="task-desc">
                    <div class="task-description">
                        <label for="date">Task description :</label>
                        <textarea id="description" class="description" name="description" required></textarea>
                    </div>
                </div>
                <div class="task-action d-flex flex-row justify-content-between">
                    <div class="left d-flex flex-column justify-content-between">
                        <h6>Priority &#x2794;</h6>
                        <label for="high">
                            <input hidden type="radio" class="priority" id="high" name="priority" value="HIGH">
                            <p class="btn-high button">High</p>
                        </label>
                        <label for="medium">
                            <input hidden type="radio" class="priority" id="medium" name="priority" value="MEDIUM">
                            <p class="btn-medium button">Medium</p>
                        </label>
                        <label for="low">
                            <input hidden type="radio" class="priority" id="low" name="priority" value="LOW">
                            <p class="btn-low button">Low</p>
                        </label>
                    </div>
                    <div class="div middle-1 left d-flex flex-column justify-content-between">
                        <h6>Status &#x2794;</h6>
                        <label for="done">
                            <input hidden type="radio" class="status" id="done" name="status" value="COMPLETED">
                            <p class="btn-done button">Done</p>
                        </label>
                        <label for="inprogress">
                            <input hidden type="radio" class="status" id="inprogress" name="status" value="IN_PROGRESS">
                            <p class="btn-inprogress button">Pending</p>
                        </label>
                        <label for="todo">
                            <input hidden type="radio" class="status" id="todo" name="status" value="TODO">
                            <p class="btn-todo button">ToDo</p>
                        </label>
                    </div>
                    <div class="middle-2 left">
                        <h6 for="priority">CheckList :</h6>
                        <label for="checklist">
                            <i class="fa-solid fa-plus"></i>
                        </label>
                    </div>
                    <div class="right d-flex flex-column justify-content-between">
                        <div>
                            <h6 for="priority">Notification :</h6>
                            <label for="notification">
                                <span>Suivre</span>
                                <i class="fa-solid fa-eye"></i>
                            </label>
                        </div>
                        <div class="btn-task">
                            <input hidden="hidden" value="${id}" name="id">
                            <input hidden="hidden" value="${task.getId()}" name="idTask">
                            <input hidden="hidden" value="${projectName}" name="name">
                            <button type="submit">Update &#x2794;</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
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

