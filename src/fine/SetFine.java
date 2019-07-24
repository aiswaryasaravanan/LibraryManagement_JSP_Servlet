package fine;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.user.*;

public class SetFine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		UserDAO userdao=new UserDAOImpl();
		float amount=Float.parseFloat(request.getParameter("amount"));
		
		try {
			userdao.setFine((String)session.getAttribute("id"),amount);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		response.sendRedirect("StudentHomePage");

	}
		

}
