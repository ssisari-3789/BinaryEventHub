<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Event</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #007BFF;
            color: white;
            text-align: center;
            padding: 20px;
        }

        .content {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 70vh;
        }

        form {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0px 0px 5px #ccc;
            padding: 20px;
            text-align: center;
            width: 400px;
        }

        .form-input {
            margin: 10px;
            text-align: left;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input {
            width: 93%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-button {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            padding: 10px 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Add Event</h1>
    </div>

    <div class="content">
        <form action="addEvent" method="POST">
            <div class="form-input">
                <label for="name">Event Name:</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="form-input">
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" required>
            </div>

            <div class="form-input">
                <label for="participants">No of Participants:</label>
                <input type="number" id="participants" name="participants" required>
            </div>

            <div class="form-input">
                <label for="organizer">Organizer:</label>
                <input type="text" id="organizer" name="organizer" required>
            </div>
            
            <div class="form-input">
                <label for="organizer">Organizer Phone No:</label>
                <input type="text" id="organizerPhone" name="organizerPhone" required>
            </div>

            <div class="form-input">
                <label for="date">Date:</label>
                <input type="date" id="date" name="date" required>
            </div>

            <div class="form-input">
                <label for="time">Time:</label>
                <input type="time" id="time" name="time" required>
            </div>

            <div class="form-input">
                <button type="submit" name="submit" class="form-button">Add Event</button>
            </div>
        </form>
    </div>
</body>
</html>
