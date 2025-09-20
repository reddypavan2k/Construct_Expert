<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/05/2024
  Time: 10:23
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
                    <a class="nav-link hovered my-2" href="dashboard">
                        <i class='bx bxs-dashboard'></i>
                        <span class="text nav-text">Dashboard</span>
                    </a>
                    <a class="nav-link my-2 active" href="projects">
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
    <div class="cardBox">
        <div class="card">
            <div>
                <div class="numbers">${total_project}</div>
                <div class="cardName">Projects</div>
            </div>

            <div class="iconBx">
                <i class="fa-solid fa-rocket"></i>
            </div>
        </div>

        <div class="card">
            <div>
                <div class="numbers">${total_resource}</div>
                <div class="cardName">Resource</div>
            </div>

            <div class="iconBx">
                <i class="fa-solid fa-building-wheat"></i>
            </div>
        </div>

        <div class="card">
            <div>
                <div class="numbers">${total_employee}</div>
                <div class="cardName">Employee</div>
            </div>

            <div class="iconBx">
                <i class="fa-solid fa-building-user"></i>
            </div>
        </div>

        <div class="card">
            <div>
                <div class="numbers">$${total_budget}K</div>
                <div class="cardName">Budget</div>
            </div>

            <div class="iconBx">
                <i class="fa-brands fa-bitcoin"></i>
            </div>
        </div>
    </div>
    <div class="chartsBx">
        <div class="chart"> <canvas id="chart-1"></canvas> </div>
        <div class="chart"> <canvas id="chart-2"></canvas> </div>
    </div>
    <div id='calendar'></div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/chart.js"%></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.13/index.global.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/daygrid@6.1.13/index.global.min.js'></script>
<script><%@include file="js/calendar.js"%></script>

<script>
    const ctx1 = document.getElementById("chart-1").getContext("2d");
    const myChart = new Chart(ctx1, {
        type: "doughnut",
        data: {
            labels: ["Project", "Resource", "employee"],
            datasets: [
                {
                    label: "# of Votes",
                    data: [${total_project}, ${total_resource}, ${total_employee}],
                    backgroundColor: [
                        "#FF914C",
                        "#FFBD59",
                        "#D9D9D9",
                    ],
                },
            ],
        },
        options: {
            responsive: true,
        },
    });

    const ctx2 = document.getElementById("chart-2").getContext("2d");
    const myChart2 = new Chart(ctx2, {
        type: "bar",
        data: {

            labels: [
                <c:forEach var="project" items="${projects}">
                "${project.getName()}",
                </c:forEach>
            ],
            datasets: [
                {
                    label: "Budget",
                    data: [
                        <c:forEach var="project" items="${projects}">
                        ${project.getBudget()},
                        </c:forEach>
                    ],
                    backgroundColor: [
                        "#FF914C",
                        "#FFBD59",
                        "#D9D9D9",
                    ],
                },
            ],
        },
        options: {
            responsive: true,
        },
    });

    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var events = [
            <c:forEach var="project" items="${projects}">
            {
                title: '${project.getName()}',
                start: '${project.getDateStart()}',
                end: '${project.getDateEnd()}',
                extendedProps: {
                    contributors: [
                        '${project.getPicture()}',
                        '${user.getPicture()}'
                    ],
                    progress: ${project.getProgress()}
                }
            },
            </c:forEach>
        ];

        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            events: events,
            eventContent: function(info) {
                var card = document.createElement('div');
                card.classList.add('fc-event-card');

                var title = document.createElement('div');
                title.classList.add('fc-title');
                title.textContent = info.event.title;
                card.appendChild(title);

                if (info.event.extendedProps.contributors) {
                    var contributorsContainer = document.createElement('div');
                    contributorsContainer.classList.add('fc-contributors');

                    info.event.extendedProps.contributors.forEach(function(url) {
                        var img = document.createElement('img');
                        img.src = url;
                        contributorsContainer.appendChild(img);
                    });

                    card.appendChild(contributorsContainer);
                }

                if (info.event.extendedProps.progress !== undefined) {
                    var progressContainer = document.createElement('div');
                    progressContainer.classList.add('fc-progress');

                    var progressBar = document.createElement('div');
                    progressBar.classList.add('fc-progress-bar');
                    progressBar.style.width = info.event.extendedProps.progress + '%';

                    progressContainer.appendChild(progressBar);
                    card.appendChild(progressContainer);
                }

                return { domNodes: [card] };
            }
        });

        calendar.render();
    });
</script>

</body>
</html>
