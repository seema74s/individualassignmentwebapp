<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fitness.UserAccount" %>
<%@ page import="com.fitness.Fitness" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fitness Form</title>
</head>
<body>
    <h2>Fitness Information</h2>
    <form action="fitnessServlet" method="post">
        <label for="currentWeight">Current Weight:</label>
        <input type="number" id="currentWeight" name="currentWeight" step="0.1" required><br><br>
        <label for="goalWeight">Goal Weight:</label>
        <input type="number" id="goalWeight" name="goalWeight" step="0.1" required><br><br>
        <label for="nutrition">Nutrition:</label>
        <textarea id="nutrition" name="nutrition" required></textarea><br><br>
        <label for="duration">Duration (in weeks):</label>
        <input type="number" id="duration" name="duration" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
