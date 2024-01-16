<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Account</title>
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
            height: 50vh;
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

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container a {
            text-decoration: none;
        }

        .button {
            display: inline-block;
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            margin: 10px;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>My Account</h1>
    </div>

    <div class="navigation">
        <a href="<c:url value="/EventServlet" />">Events</a>
    </div>

    <div class="content">
        <table>
            <c:forEach var="cus" items="${cusDetails}">
                <c:set var="id" value="${cus.id}" />
                <c:set var="name" value="${cus.name}" />
                <c:set var="email" value="${cus.email}" />
                <c:set var="phone" value="${cus.phone}" />
                <c:set var="username" value="${cus.userName}" />
                <c:set var="password" value="${cus.password}" />

                <tr>
                    <td>Customer ID</td>
                    <td>${cus.id}</td>
                </tr>
                <tr>
                    <td>Customer Name</td>
                    <td>${cus.name}</td>
                </tr>
                <tr>
                    <td>Customer Email</td>
                    <td>${cus.email}</td>
                </tr>
                <tr>
                    <td>Customer Phone</td>
                    <td>${cus.phone}</td>
                </tr>
                <tr>
                    <td>Customer User Name</td>
                    <td>${cus.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="button-container">
        <c:url value="updatecustomer.jsp" var="cusupdate">
            <c:param name="id" value="${id}" />
            <c:param name="name" value="${name}" />
            <c:param name="email" value="${email}" />
            <c:param name="phone" value="${phone}" />
            <c:param name="uname" value="${username}" />
            <c:param name="pass" value="${password}" />
        </c:url>

        <a href="${cusupdate}" class="button">Update My Data</a>

        <!--<c:url value="deletecustomer.jsp" var="cusdelete">
            <c:param name="id" value="${id}" />
            <c:param name="name" value="${name}" />
            <c:param name="email" value="${email}" />
            <c:param name="uname" value="${username}" />
            <c:param name="pass" value="${password}" />
        </c:url>

        <a href="${cusdelete}" class="button">Delete My Account</a>-->
    </div>
</body>
</html>
