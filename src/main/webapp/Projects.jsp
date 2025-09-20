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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <style><%@include file="css/style.css"%></style>
    <link rel="stylesheet" href="css/dashboard.css">
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
<section class="main">
    <div class="main-header d-flex flex-row justify-content-between">
        <div class="main-section">
            <h6>Projects</h6>
            <span>Number of projects : ${total_project}</span>
        </div>
        <div class="main-actions d-flex flex-row justify-content-around">
            <div class="filter">
                <i class="fa-solid fa-filter"></i>
                <span>Filter</span>
            </div>
            <div class="featured">
                <span>Featured</span>
                <i class="fa-solid fa-sort-down"></i>
            </div>
            <div class="sort">
                <i class="fa-brands fa-microsoft"></i>
                <i class="fa-solid fa-list"></i>
            </div>
        </div>
    </div>
    <div class="main-scroll  d-flex flex-row">
        <c:forEach var="project" items="${projects}">
        <div class="project-card card justify-content-between d-flex flex-column">

            <div class="dropdown">
                <button class="btn dropdown-toggle-split" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fa-solid fa-ellipsis"></i>
                </button>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="view-detail?id=${project.getId()}">View Detail</a></li>
                    <li><a class="dropdown-item item-update" href="update-project?id=${project.getId()}">Update</a></li>
                    <li><a class="dropdown-item" href="delete-project?id=${project.getId()}">Delete</a></li>
                </ul>
            </div>
            <img src="${project.getPicture()}" class="card-img-top project-img" alt="Room Image">
            <div class="project-head d-flex flex-row justify-content-between align-items-center">
                <h6>${project.getName()}</h6>
                <span>budget : ${project.getBudget()} $</span>
            </div>
            <div class="d-flex flex-row progresss justify-content-between align-items-center">
                <span>Progress </span>
                <div class="progress-project">
                    <c:if test="${project.getStatus() eq 'TODO'}">
                    <div style="width: ${project.getProgress()}%; background-color: red" class="progressed"></div>
                    </c:if>
                    <c:if test="${project.getStatus() eq 'IN_PROGRESS'}">
                        <div style="width: ${project.getProgress()}%; background-color: darkgreen" class="progressed"></div>
                    </c:if>
                    <c:if test="${project.getStatus() eq 'COMPLETED'}">
                        <div style="width: ${project.getProgress()}%; background: #FF914C" class="progressed"></div>
                    </c:if>
                </div>
            </div>
            <div class="project-details d-flex flex-row justify-content-between mt-2">
                <div class="size d-flex flex-column">
                    <i class="fa-solid fa-ruler-combined"></i>
                    <span>${project.getAreaSize()} m²</span>
                </div>
                <div class="geolocation d-flex flex-column">
                    <i class="fa-solid fa-map-location-dot"></i>
                    <span>${project.getGeolocation()}</span>
                </div>
                <div class="room d-flex flex-column">
                    <i class="fa-solid fa-door-open"></i>
                    <span>${project.getRoom()} rooms</span>
                </div>
            </div>
            <div class="project-action">
                <a href="tasks?id=${project.getId()}&name=${project.getName()}">Show Tasks</a>
            </div>
        </div>
        </c:forEach>
        <div class="add">
            <a href="add-project">
                <i class="fa-thin fa-plus"></i>
                <h6>Add Project</h6>
            </a>
        </div>
    </div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/script.js"%></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
