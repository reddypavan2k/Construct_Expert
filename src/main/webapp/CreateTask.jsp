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
            <h6>Projects <span>&#x2794; Create Task</span> <span>&#x2794; ${projectName}</span></h6>
        </div>
    </div>
    <div class="create-task">
        <form action="add-task" method="post">
            <div class="form-task">
                <div class="task-head d-flex flex-row justify-content-between">
                    <div class="task-title">
                        <label for="title">Task title :</label>
                        <i class="fa-solid fa-thumbtack"></i>
                        <input type="text" id="title" class="title" name="title" placeholder="Enter task title "
                               required>
                    </div>
                    <div class="task-type">
                        <label for="type">Task type :</label>
                        <i class="fa-solid fa-font-awesome"></i>
                        <input type="text" id="type" class="type" name="type" placeholder="Enter task type "
                               required>
                    </div>
                    <div class="due-date">
                        <label for="date">Task due date :</label>
                        <input type="date" id="date" class="date" name="date" min="${limit}" required>
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
                            <input hidden="hidden" value="${projectName}" name="name">
                            <button type="button" class="to-resource">Next &#x2794;</button>
                        </div>
                    </div>
                </div>
            </div>
            <div style="display: none;" class="form-resource flex-column justify-content-between">
                <div class="vehicle">
                    <h6>Choose vehicle :</h6>
                    <div class="overflow">
                        <div class="scroll  d-flex flex-row">
                            <c:forEach var="vehicle" items="${vehicles}">
                            <label for="vehicle${vehicle.getId()}">
                                <img src="${vehicle.getPicture()}" alt="">
                                <input type="checkbox" name="vehicle" class="vehicle-check" id="vehicle${vehicle.getId()}" value="${vehicle.getId()}">
                                <input type="number" id="Input" max="${vehicle.getQuantity()}" name="quantityVehicle" disabled>
                                <p class="quantity">Qte</p>
                            </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="equipment">
                    <h6>Choose equipment :</h6>
                    <div class="overflow">
                        <div class="scroll  d-flex flex-row">
                            <c:forEach var="equipment" items="${equipments}">
                            <label for="equipment${equipment.getId()}">
                                <img src="${equipment.getPicture()}" alt="">
                                <input type="checkbox" name="equipment" class="equipment-check" id="equipment${equipment.getId()}" value="${equipment.getId()}" hidden>
                                <input type="number" id="Input" max="${equipment.getQuantity()}" name="quantityEquipment" disabled>
                                <p class="quantity">Qte</p>
                            </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="material">
                    <h6>Choose material :</h6>
                    <div class="overflow">
                        <div class="scroll  d-flex flex-row">
                            <c:forEach var="material" items="${materials}">
                            <label for="material${material.getId()}">
                                <img src="${material.getPicture()}" alt="">
                                <input type="checkbox" name="material" class="material-check" id="material${material.getId()}" value="${material.getId()}" hidden>
                                <input type="number" id="Input" max="${material.getQuantity()}" name="quantityMaterial" disabled>
                                <p class="quantity">Qte</p>
                            </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="resource-action">
                    <button type="button" class="to-employee">Next &#x2794;</button>
                </div>
            </div>
            <div style="display: none;" class="form-employee flex-column justify-content-between">
                <div class="supervisor">
                    <h6>Choose supervisor :</h6>
                    <div class="overflow">
                        <div class="scroll d-flex flex-row">
                            <c:forEach var="supervisor" items="${supervisors}">
                            <label for="supervisor${supervisor.getId()}">
                                <img src="${supervisor.getPicture()}" alt="">
                                <input type="radio" class="supervisor-check" name="supervisor" id="supervisor${supervisor.getId()}" value="${supervisor.getId()}" hidden>
                                <p>${supervisor.getName()}</p>
                            </label>
                            </c:forEach>
                        </div>
                    </div>

                </div>
                <div class="team">
                    <h6>Choose team :</h6>
                    <div class="overflow">
                        <div class="scroll d-flex flex-row">
                            <c:forEach var="team" items="${teams}">
                            <label for="team${team.getId()}">
                                <img src="${team.getPicture()}" alt="">
                                <input type="radio" class="team-check" name="team" id="team${team.getId()}" value="${team.getId()}" hidden>
                                <p>${team.getName()}</p>
                            </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="action-submit">
                    <button type="submit">Create</button>
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
