<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Events</title>
    <style type="text/css">
        body {
            font-family: Hind SemiBold;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #007BFF;
            color: white;
            text-align: center;
            padding: 10px;
        }

        .navigation {
            background-color: #333;
            padding: 10px;
            text-align: left;
        }

        .navigation a {
            color: white;
            text-decoration: none;
            margin: 10px;
        }

        .content {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            border: 1px solid black;
            margin: 10px;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        
        .custom-button {
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            padding: 5px 10px;
            margin: 0 5px;
        }
        
        .edit-button {
        	background-color: #007BFF;
        }
        
        .delete-button{
        	background-color: #ff0019;
        }
        
        /* Styles for the confirmation modal */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #f4f4f4;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 40%;
            text-align: center;
        }

        /* Styles for the confirmation buttons */
        .modal-button {
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            padding: 5px 10px;
            margin: 0 5px;
        }
        
        .search-container {
            text-align: center;
            margin: 20px;
        }

        #searchBox {
            padding: 10px;
        }

        .search-button {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Events</h1>
    </div>
    
    <!-- Navigation section with the "Add Event" button -->
	<div class="navigation">
	    <a href="AddEvent.jsp" class="custom-button add-button">Add Event</a>
	</div>
    
    <form action="EventServlet" method="GET" class="search-container">
	    <input type="text" name="searchQuery" id="searchBox" placeholder="Search by name" />
	    <button type="submit" class="search-button">Search</button>
	    <button type="reset" class="search-button" onclick="clearSearch()">Clear Search</button>
	</form>


    
    <div class="content">
        <table>
            <tr>
            	<th>#</th> <!-- Added column for row numbers -->
                <th>Event Name</th>
                <th>Location</th>
                <th>No of Participants</th>
                <th>Organizer</th>
                <th>Date</th>
                <th>Time</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="event" items="${allEvents}" varStatus="loop">
                <tr>
                	<td>${loop.index + 1}</td>
                    <td>${event.name}</td>
                    <td>${event.location}</td>
                    <td>${event.noOfParticipants}</td>
                    <td>${event.organizer}</td>
                    <td>${event.date}</td>
                    <td>${event.time}</td>
                    <td><a href="UpdateEvent.jsp?id=${event.id}"><button class="custom-button edit-button">Edit</button></a></td>
                    <td><button class="custom-button delete-button" onclick="confirmDelete(${event.id})">Delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <!-- Confirmation Modal -->
    <div id="deleteModal" class="modal">
        <div class="modal-content">
            <p>Are you sure you want to delete this event?</p>
            <button class="modal-button delete-button" onclick="deleteEvent()">Yes</button>
            <button class="modal-button edit-button" onclick="closeModal()">No</button>
        </div>
    </div>

    <input type="hidden" id="eventToDelete" value="" />

    <script>
        function confirmDelete(eventId) {
            // Display the confirmation modal
            document.getElementById('deleteModal').style.display = 'block';
            // Set the event ID to be deleted
            document.getElementById('eventToDelete').value = eventId;
        }

        function deleteEvent() {
            // Get the event ID to be deleted
            var eventId = document.getElementById('eventToDelete').value;

            // Send an AJAX request to delete the event
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'EventServlet', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // Handle the response here (e.g., refresh the event data)
                    location.reload(); // Reload the page to refresh the event data
                }
            };
            xhr.send('action=delete&eventId=' + eventId);
        }

        function closeModal() {
            // Close the confirmation modal
            document.getElementById('deleteModal').style.display = 'none';
        }
    </script>
</body>
</html>
