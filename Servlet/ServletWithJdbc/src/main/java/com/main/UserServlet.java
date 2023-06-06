package com.main;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		 Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    		
    		// Retrieve all users from the database
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String selectQuery = "SELECT * FROM users";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            ResultSet resultSet = selectStmt.executeQuery();

            // Generate dynamic response with user data
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>User List:</h2>");
            while (resultSet.next()) {
                String storedUsername = resultSet.getString("username");
                String storedEmail = resultSet.getString("email");
                out.println("<p>Username: " + storedUsername + ", Email: " + storedEmail + "</p>");
            }
            out.println("</body></html>");
            
            resultSet.close();
            selectStmt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        try {
            // Store user data in the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String insertQuery = "INSERT INTO users (username, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
