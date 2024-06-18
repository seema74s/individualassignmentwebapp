<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fitness.Fitness" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Fitness Information</title>
</head>
<body>
    <h2>Your Fitness Information</h2>
    <%
        HttpSession session = request.getSession();
        Fitness fitness = (Fitness) session.getAttribute("fitness");
        if (fitness != null) {
    %>
    <p>Current Weight: <%= fitness.getCurrentWeight() %></p>
    <p>Goal Weight: <%= fitness.getGoalWeight() %></p>
    <p>Nutrition: <%= fitness.getNutrition() %></p>
    <p>Duration: <%= fitness.getDuration() %> weeks</p>
    <%
        } else {
            out.println("No fitness information available.");
        }
    %>
</body>
</html>
