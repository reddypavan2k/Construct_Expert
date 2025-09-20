<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24/05/2024
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a class="nav-link my-2" href="projects">
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
                    <a class="nav-link hovered my-2 active" href="materials">
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
            <h6>Materials <span>&#x2794; Update Material</span></h6>
        </div>
    </div>
    <div class="create">
        <form action="update-material" method="post" class="d-flex flex-row">
            <div class="resource-left resource">
                <div class="title">
                    <label for="title">Title :</label>
                    <i class="fa-solid fa-recycle"></i>
                    <input type="text" id="title" class="title" name="title"
                           placeholder="Enter material title " required value="${material.getTitle()}">
                </div>
                <div class="type">
                    <label for="type">Type :</label>
                    <i class="fa-solid fa-dna"></i>
                    <input type="text" id="type" class="type" name="type"
                           placeholder="Enter material type " required value="${material.getType()}">
                </div>
                <div class="provider">
                    <label for="provider">Provider :</label>
                    <i class="fa-solid fa-store"></i>
                    <input type="text" id="provider" class="provider" name="provider"
                           placeholder="Enter material provider " required value="${material.getProvider()}">
                </div>
            </div>
            <div class="resource-right resource">
                <div class="acquisitionDate">
                    <label for="acquisitionDate">Acquisition Date :</label>
                    <input type="date" id="acquisitionDate" class="acquisitionDate" name="acquisitionDate" required value="${material.getAcquisitionDate()}">
                </div>
                <div class="picture">
                    <label for="provider">Picture :</label>
                    <i class="fa-solid fa-image"></i>
                    <input type="url" id="picture" class="picture" name="picture"
                           placeholder="Enter material picture " required value="${material.getPicture()}">
                </div>
                <div class="quantity">
                    <label for="quantity">Quantity :</label>
                    <i class="fa-solid fa-layer-group"></i>
                    <input type="number" id="quantity" class="quantity" name="quantity"
                           placeholder="Enter material quantity" required value="${material.getQuantity()}">
                </div>
            </div>
            <input hidden="hidden" value="${material.getId()}" name="id">
            <button type="submit" class="btn resource-btn">Update</button>
        </form>
    </div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>




</body>

</html>