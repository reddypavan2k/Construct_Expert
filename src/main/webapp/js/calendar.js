// full calendar
   /* document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var events = [
            {
                title: 'Projet 1',
                start: '2024-05-01',
                end: '2024-05-03',
                contributors: [
                    'https://th.bing.com/th/id/OIP.mZJt_Xli7Gj3AIXoCbbfUAHaHa?rs=1&pid=ImgDetMain'
                ],
                progress: 70
            },
            {
                title: 'Projet 2',
                start: '2024-05-07',
                end: '2024-05-10',
                contributors: [
                    'https://th.bing.com/th/id/OIP.mZJt_Xli7Gj3AIXoCbbfUAHaHa?rs=1&pid=ImgDetMain'
                ],
                progress: 45
            },
            {
                title: 'Projet 3',
                start: '2024-05-15',
                end: '2024-05-18',
                contributors: [
                    'https://th.bing.com/th/id/OIP.mZJt_Xli7Gj3AIXoCbbfUAHaHa?rs=1&pid=ImgDetMain'
                ],
                progress: 85
            }
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
    });*/
