<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>New Ninja</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/dojos">Dojos and Ninjas</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/dojos">All Dojos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dojos/new">Create Dojo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ninjas/new">Create Ninja</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="container py-3">
    <h1 class="display-4 mb-3">New Ninja</h1>

    <div class="card shadow">
        <div class="card-body">
            <form action="/ninjas/create" method="post">
                <div class="mb-3">
                    <label for="dojo" class="form-label">Dojo:</label>
                    <select id="dojo" name="dojo.id" class="form-select">
                        <c:forEach var="dojo" items="${dojos}">
                            <option value="${dojo.id}">${dojo.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name:</label>
                    <input type="text" id="firstName" name="firstName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="age" class="form-label">Age:</label>
                    <input type="number" id="age" name="age" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </div>
    <a href="/dojos">View All Dojos</a> <!-- Hyperlink to view all dojos -->
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
