package com.fitness;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class FitnessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double currentWeight = Double.parseDouble(request.getParameter("currentWeight"));
        double goalWeight = Double.parseDouble(request.getParameter("goalWeight"));
        String nutrition = request.getParameter("nutrition");
        int duration = Integer.parseInt(request.getParameter("duration"));

        HttpSession session = request.getSession();
        UserAccount user = (UserAccount) session.getAttribute("user");

        if (user != null) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = Connection.getConnection();
                String query = "INSERT INTO fitness (userId, currentWeight, goalWeight, nutrition, duration) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setDouble(2, currentWeight);
                preparedStatement.setDouble(3, goalWeight);
                preparedStatement.setString(4, nutrition);
                preparedStatement.setInt(5, duration);
                preparedStatement.executeUpdate();

                Fitness fitness = new Fitness();
                fitness.setUserId(user.getId());
                fitness.setCurrentWeight(currentWeight);
                fitness.setGoalWeight(goalWeight);
                fitness.setNutrition(nutrition);
                fitness.setDuration(duration);

                session.setAttribute("fitness", fitness);
                response.sendRedirect("display.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
