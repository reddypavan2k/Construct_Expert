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
            <h6>Projects <span>&#x2794; Create Project</span></h6>
        </div>
    </div>
    <div class="create">
        <form action="add-project" method="post" class="d-flex flex-column">
            <div class="up d-flex flex-row">
                <div class="up-left">
                    <div class="name">
                        <label for="name">Name :</label>
                        <i class="fa-solid fa-rocket"></i>
                        <input type="text" id="name" class="name" name="name"
                               placeholder="Enter project name " required>
                    </div>
                    <div class="geolocation">
                        <label for="geolocation">Geolocation :</label>
                        <i class="fa-solid fa-location-crosshairs"></i>
                        <input type="text" id="geolocation" class="geolocation" name="geolocation"
                               placeholder="Enter project geolocation " required>
                    </div>
                    <div class="description">
                        <label for="geolocation">Description :</label>
                        <i class="fa-solid fa-file-waveform"></i>
                        <input type="text" id="description" class="description" name="description"
                               placeholder="Enter project description " required>
                    </div>
                </div>
                <div class="up-middle">
                    <div class="status">
                        <label for="status">Status</label>
                        <i class="fa-solid fa-signal"></i>
                        <select class="form-control" id="status" name="status" required>
                            <option>Select</option>
                            <option value="TODO">Pending</option>
                            <option value="IN_PROGRESS">InProgress</option>
                            <option value="COMPLETED">Completed</option>
                        </select>
                    </div>
                    <div class="dateStart">
                        <label for="dateStart">Date start :</label>
                        <input style="padding-left: 5px;" type="date" id="dateStart" class="dateStart" name="dateStart" required>
                    </div>
                    <div class="dateEnd">
                        <label for="dateEnd">Date end :</label>
                        <input style="padding-left: 5px;" type="date" id="dateEnd" class="dateEnd" name="dateEnd" required>
                    </div>
                </div>
                <div class="up-middel-2">
                    <div class="Picture">
                        <label for="picture">Picture :</label>
                        <i class="fa-solid fa-image"></i>
                        <input type="url" id="picture" class="picture" name="picture"
                               placeholder="Enter project picture " required>
                    </div>
                    <div class="planFloor">
                        <label for="planFloor">Plan floor :</label>
                        <i class="fa-regular fa-map"></i>
                        <input type="url" id="planFloor" class="planFloor" name="planFloor"
                               placeholder="Enter project plan floor" required>
                    </div>
                    <div class="room">
                        <label for="room">Room :</label>
                        <i class="fa-solid fa-person-booth"></i>
                        <input type="number" id="room" class="room" name="room"
                               placeholder="Enter project rooms " required>
                    </div>
                </div>
                <div class="up-right">
                    <div class="bath">
                        <label for="bath">Bath :</label>
                        <i class="fa-solid fa-bath"></i>
                        <input type="number" id="bath" class="bath" name="bath"
                               placeholder="Enter project bath " required>
                    </div>
                    <div class="garage">
                        <label for="garage">Garage :</label>
                        <i class="fa-solid fa-warehouse"></i>
                        <input type="number" id="garage" class="garage" name="garage"
                               placeholder="Enter project garage" required>
                    </div>
                    <div class="terrace">
                        <label for="terrace">Terrace :</label>
                        <i class="fa-solid fa-mug-saucer"></i>
                        <input type="number" id="terrace" class="terrace" name="terrace"
                               placeholder="Enter project terrace " required>
                    </div>
                </div>
            </div>
            <div class="down d-flex flex-row">
                <div class="down-left">
                    <div class="down-left-head">
                        <h4>Calculating & estimate the construction</h4>
                        <p>Calculating construction costs involves analyzing key factors such as material quality (concrete, steel, finishes), foundation type (shallow or deep), and labor costs.</p>
                    </div>
                    <div class="composante">
                        <span>Choose wall material</span>
                        <div class="wall-material d-flex flex-row">
                            <label class="wall-material-type" ><input style="display: none;" type="radio" value="Ceramic Block" id="wallMaterial" class="wallMaterial" name="wallMaterial" data-price="200">
                                <img src="assets/ceramic-brick.png" alt=""><p>Ceramic Block</p>
                            </label>
                            <label class="wall-material-type" ><input style="display: none;" type="radio" value="Silicate Brick" id="wallMaterial" class="wallMaterial" name="wallMaterial" data-price="150">
                                <img src="assets/silicate-brick.png" alt=""><p>Silicate brick</p>
                            </label>
                            <label class="wall-material-type" ><input style="display: none;" type="radio" value="Fired Brick" id="wallMaterial" class="wallMaterial" name="wallMaterial" data-price="100">
                                <img src="assets/fired-brick.jpg" alt=""><p style="padding-left: 10px;">Fired brick</p>
                            </label>
                            <label class="wall-material-type" ><input style="display: none;" type="radio" value="Wood Panel" id="wallMaterial" class="wallMaterial" name="wallMaterial" data-price="300">
                                <img src="assets/wood-panel.png" alt=""><p>Wood panel</p>
                            </label>
                        </div>
                        <div class="down-composante d-flex flex-row">
                            <div class="foundation-type">
                                <span>Choose type of foundation</span>
                                <div class="d-flex flex-row">
                                    <label class="foundation-type" ><input style="display: none;" type="radio" value="Monolithic" id="foundationType" class="foundationType" name="foundationType" data-price="500">
                                        <img src="assets/monolothic.png" alt=""><p style="padding-left: 10px;">Monolithic</p>
                                    </label>
                                    <label class="foundation-type" ><input style="display: none;" type="radio" value="Pile" id="foundationType" class="foundationType" name="foundationType" data-price="400">
                                        <img src="assets/Pile.png" alt=""><p style="padding-left: 25px;">Pile</p>
                                    </label>
                                </div>
                            </div>
                            <div class="roofling-type">
                                <span>Choose type of roofing</span>
                                <div class="d-flex flex-row">
                                    <label class="roofling-type" ><input style="display: none;" type="radio" value="Metal" id="rooflingType" class="rooflingType" name="roofingType" data-price="100">
                                        <img src="assets/metal.png" alt=""><p style="padding-left: 25px;">Metal</p>
                                    </label>
                                    <label class="roofling-type" ><input style="display: none;" type="radio" value="Tiles" id="rooflingType" class="rooflingType" name="roofingType" data-price="50">
                                        <img src="assets/tiles.png" alt=""><p style="padding-left: 25px;">Tiles</p>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="down-right">
                    <h4>Estimation</h4>
                    <div class="ligne d-flex flex-row justify-content-between">
                        <p>Name</p>
                        <p>Price, USD/m²</p>
                    </div>
                    <div class="ligne d-flex flex-row justify-content-between">
                        <span class="title">Wall Material</span>
                        <span class="material" id="wallMaterial-selected">---</span>
                        <span class="price" id="wallMaterial-price">--</span>
                    </div>
                    <div class="ligne d-flex flex-row justify-content-between">
                        <span class="title">Type foundation</span>
                        <span class="material" id="foundationType-selected">---</span>
                        <span class="price" id="foundationType-price">--</span>
                    </div>
                    <div class="ligne d-flex flex-row justify-content-between">
                        <span class="title">Roofling type</span>
                        <span class="material" id="rooflingType-selected">---</span>
                        <span class="price" id="rooflingType-price">--</span>
                    </div>
                    <div class="ligne pt-4">
                        <p>Specify the area size of the house :</p>
                        <span  class="des-area">Please specify the total area size of your house to receive an accurate budget estimate. This includes all living spaces, bedrooms, bathrooms, kitchen, and any additional areas like garages and terraces. </span>
                        <div class="d-flex flex-row mt-3" style="gap: 10px;">
                            <label class="d-flex flex-row align-content-center"><input type="number" id="areaSize" class="areaSize" name="areaSize" required>
                                <span style="margin-left: -30px;">m²</span>
                            </label>
                            <label class="d-flex flex-row align-content-center"><input type="number" id="budget" class="budget" name="budget" readonly>
                                <span style="margin-left: -15px;">$</span>
                            </label>
                            <button class="btn-submit">Create</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/script.js"%></script>



</body>

</html>