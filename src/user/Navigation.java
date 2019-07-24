package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DataBaseConnection;
import bean.book.*;
import bean.user.*;

public class Navigation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		UserDAO userdao =new UserDAOImpl();
		try {
			if(userdao.isAdmin((String) session.getAttribute("id")))
				response.sendRedirect("AdminHomePage");
			else
				response.sendRedirect("StudentHomePage");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
