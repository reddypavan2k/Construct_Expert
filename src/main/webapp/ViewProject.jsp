<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24/05/2024
  Time: 23:48
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
        <div class="main-section">
            <h6>Projects <span>&#x2794; View Project</span> <span>&#x2794; ${project.getName()}</span></h6>
        </div>
    </div>
    <div class="view-project-head d-flex flex-row justify-content-between">
        <div class="view-project-action d-flex flex-row justify-content-between">
            <h6 class="actived-view project-action overview-action">Overview</h6>
            <h6 class="project-action gallery-action">Project Gallery</h6>
        </div>
        <a href="tasks?id=${project.getId()}&name=${project.getName()}">Show Tasks</a>
    </div>
    <div class="overview">
        <div class="view-description">
            <div class="description">
                <h6>${project.getName()} &#x2794;</h6>
                <p>${project.getDescription()}</p>
            </div>
        </div>
        <div class="view-plan d-flex flex-row">
            <div class="plan-left d-flex flex-column justify-content-between">
                <h6>PLan details &#x2794;</h6>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-location-crosshairs"></i>
                    <span>${project.getGeolocation()}</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-ruler-combined"></i>
                    <span>${project.getAreaSize()} m²</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-sack-dollar"></i>
                    <span>${project.getBudget()} $</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-door-open"></i>
                    <span>${project.getRoom()} Room</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-bath"></i>
                    <span>${project.getBath()} Bath</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-warehouse"></i>
                    <span>${project.getGarage()} Garage</span>
                </div>
                <div class="details d-flex flex-row align-items-center">
                    <i class="fa-solid fa-mug-saucer"></i>
                    <span>${project.getTerrace()} Terrace</span>
                </div>
            </div>
            <div class="plan-middle d-flex flex-column justify-content-around align-items-center">
                <c:if test="${project.getWallMaterial() eq 'Ceramic Block'}">
                <label class="wall-material-type" >
                    <img src="assets/ceramic-brick.png" alt=""><p>Ceramic Block</p>
                </label>
                </c:if>
                <c:if test="${project.getWallMaterial() eq 'Silicate Brick'}">
                <label class="wall-material-type" >
                    <img src="assets/silicate-brick.png" alt=""><p>Silicate brick</p>
                </label>
                </c:if>
                <c:if test="${project.getWallMaterial() eq 'Fired Brick'}">
                <label class="wall-material-type" >
                    <img src="assets/fired-brick.jpg" alt=""><p style="padding-left: 10px;">Fired brick</p>
                </label>
                </c:if>
                <c:if test="${project.getWallMaterial() eq 'Wood Panel'}">
                <label class="wall-material-type" >
                    <img src="assets/wood-panel.png" alt=""><p>Wood panel</p>
                </label>
                </c:if>
                <c:if test="${project.getFoundationType() eq 'Monolithic'}">
                    <label class="foundation-type">
                        <img src="assets/monolothic.png" alt=""><p style="padding-left: 10px;">Monolithic</p>
                    </label>
                </c:if>
                <c:if test="${project.getFoundationType() eq 'Pile'}">
                    <label class="foundation-type">
                        <img src="assets/Pile.png" alt=""><p style="padding-left: 25px;">Pile</p>
                    </label>
                </c:if>
                <c:if test="${project.getRoofingType() eq 'Metal'}">
                    <label class="roofling-type">
                        <img src="assets/metal.png" alt=""><p style="padding-left: 25px;">Metal</p>
                    </label>
                </c:if>
                <c:if test="${project.getRoofingType() eq 'Tiles'}">
                    <label class="roofling-type">
                        <img src="assets/tiles.png" alt=""><p style="padding-left: 25px;">Tiles</p>
                    </label>
                </c:if>

            </div>
            <div class="plan-right">
                <h6>PLan Floor &#x2794;</h6>
                <div class="img">
                    <img src="${project.getPlanFloor()}" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="gallery">
        <div class="img">
            <img src="${project.getPicture()}" alt="">
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
